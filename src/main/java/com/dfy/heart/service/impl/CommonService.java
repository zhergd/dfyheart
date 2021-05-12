package com.dfy.heart.service.impl;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import com.dfy.heart.constants.ResponseCode;
import com.dfy.heart.dao.HeartAccessMapper;
import com.dfy.heart.dao.HeartMottoMapper;
import com.dfy.heart.dao.HeartUserMapper;
import com.dfy.heart.domain.common.Response;
import com.dfy.heart.domain.entity.*;
import com.dfy.heart.domain.request.AddAccessRequest;
import com.dfy.heart.domain.request.GetMottoRequest;
import com.dfy.heart.domain.request.GetWxConfigRequest;
import com.dfy.heart.domain.response.GetWxConfigResponse;
import com.dfy.heart.service.ICommonService;
import com.dfy.heart.util.AuthUtil;
import com.dfy.heart.util.BeanMapperUtil;
import com.dfy.heart.util.ResponseUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @description:
 * @date: 2021/4/17 15:04
 */
@Service
public class CommonService implements ICommonService {

    @Resource
    private HeartAccessMapper heartAccessMapper;

    @Resource
    private HeartMottoMapper heartMottoMapper;

    @Resource
    private HeartUserMapper heartUserMapper;

    @Resource
    private ResponseUtil responseUtil;

    @Override
    public Response<Boolean> addAccess(AddAccessRequest addAccessRequest) {
        if (StringUtils.isEmpty(addAccessRequest.getSign()) || ObjectUtils.isEmpty(addAccessRequest.getTime())) {
            return responseUtil.buildErrorResponse(ResponseCode.PARAMETER_ERROR);
        }
        if (!AuthUtil.authAccess(addAccessRequest.getSign(), addAccessRequest.getTime())) {
            return responseUtil.buildErrorResponse(ResponseCode.CHECK_SIGN_FAIL);
        }

        try {
            HeartAccess heartAccess = BeanMapperUtil.map(addAccessRequest, HeartAccess.class);
            heartAccess.setAccessTime(System.currentTimeMillis());
            heartAccessMapper.insertSelective(heartAccess);
            return responseUtil.buildSuccessResponse(true);
        } catch (Exception e) {
            return responseUtil.buildSuccessResponse(false);
        }
    }

    @Override
    public Response<String> getMotto(GetMottoRequest getMottoRequest) {
        if (StringUtils.isEmpty(getMottoRequest.getSign()) || ObjectUtils.isEmpty(getMottoRequest.getTime())) {
            return responseUtil.buildErrorResponse(ResponseCode.PARAMETER_ERROR);
        }
        if (!AuthUtil.authAccess(getMottoRequest.getSign(), getMottoRequest.getTime())) {
            return responseUtil.buildErrorResponse(ResponseCode.CHECK_SIGN_FAIL);
        }

        try {
            String mottoText = "";

            // 1.是否已经分配
            HeartUserExample heartUserExample = new HeartUserExample();
            heartUserExample.createCriteria().andUserNameEqualTo(getMottoRequest.getUserName())
                    .andUserIpEqualTo(getMottoRequest.getUserIp());
            List<HeartUser> heartUsers = heartUserMapper.selectByExample(heartUserExample);
            if (!CollectionUtils.isEmpty(heartUsers)) {
                Integer mottoId = heartUsers.get(0).getMottoId();
                HeartMotto heartMotto = heartMottoMapper.selectByPrimaryKey(mottoId);
                if (!ObjectUtils.isEmpty(mottoId) && !ObjectUtils.isEmpty(heartMotto)) {
                    mottoText = heartMotto.getMottoText();
                    return responseUtil.buildSuccessResponse(mottoText);
                }
            }

            // 2.重新分配切插入记录
            HeartMottoExample heartMottoExample = new HeartMottoExample();
            List<HeartMotto> heartMottos = heartMottoMapper.selectByExample(heartMottoExample);
            int n = new Random().nextInt(heartMottos.size());
            HeartMotto heartMotto = heartMottos.get(n);
            mottoText = heartMotto.getMottoText();

            HeartUser heartUser = new HeartUser();
            heartUser.setUserName(getMottoRequest.getUserName());
            heartUser.setUserIp(getMottoRequest.getUserIp());
            heartUser.setMottoId(heartMotto.getMottoId());
            heartUser.setCreateTime(System.currentTimeMillis());
            heartUserMapper.insertSelective(heartUser);

            return responseUtil.buildSuccessResponse(mottoText);
        } catch (Exception e) { // 异常就直接给返回一个随机值
            HeartMottoExample heartMottoExample = new HeartMottoExample();
            List<HeartMotto> heartMottos = heartMottoMapper.selectByExample(heartMottoExample);
            int n = new Random().nextInt(heartMottos.size());
            HeartMotto heartMotto = heartMottos.get(n);
            return responseUtil.buildSuccessResponse(heartMotto.getMottoText());
        }
    }

    @Override
    public Response<GetWxConfigResponse> getWxConfig(GetWxConfigRequest getWxConfigRequest) {
        if (StringUtils.isEmpty(getWxConfigRequest.getSign()) || ObjectUtils.isEmpty(getWxConfigRequest.getTime())) {
            return responseUtil.buildErrorResponse(ResponseCode.PARAMETER_ERROR);
        }
        if (!AuthUtil.authAccess(getWxConfigRequest.getSign(), getWxConfigRequest.getTime())) {
            return responseUtil.buildErrorResponse(ResponseCode.CHECK_SIGN_FAIL);
        }

        GetWxConfigResponse getWxConfigResponse = new GetWxConfigResponse();
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("grant_type", "client_credential");
        paramsMap.put("appid", "wx2621fe1afe11a1d3");
        paramsMap.put("secret", "38e75fd7da225431f9c8b34b547e0647");
        String s = HttpUtil.get("https://api.weixin.qq.com/cgi-bin/token", paramsMap);
        JSONObject jsonObject = JSONObject.parseObject(s);
        String accessToken = jsonObject.getString("access_token");
        if (StringUtils.isEmpty(accessToken)) {
            return responseUtil.buildErrorResponse(ResponseCode.FAILURE);
        }
        Map<String, Object> paramsMap2 = new HashMap<>();
        paramsMap.put("access_token", accessToken);
        paramsMap.put("type", "jsapi");
        String s2 = HttpUtil.get("https://api.weixin.qq.com/cgi-bin/ticket/getticket", paramsMap);
        JSONObject jsonObject2 = JSONObject.parseObject(s2);
        String ticket = jsonObject2.getString("ticket");
        String noncestr = RandomUtil.randomString(16);

        getWxConfigResponse.setAppId("wx2621fe1afe11a1d3");
        getWxConfigResponse.setNonceStr(noncestr);
        long nowTime = System.currentTimeMillis() / 1000;
        getWxConfigResponse.setTimestamp(String.valueOf(nowTime));


        String timestamp = String.valueOf(System.currentTimeMillis() / 1000);//随机生成的时间戳
        String signature = getSignature(getWxConfigRequest.getUrl(), timestamp, noncestr, ticket);//开始进行sha1签名
        getWxConfigResponse.setSignature(signature);

        return responseUtil.buildSuccessResponse(getWxConfigResponse);
    }

    public static String getSignature(String url, String timeStamp, String nonceStr, String ticket) {
        //所有待签名参数按照字段名的ASCII 码从小到大排序（字典序）后，使用URL键值对的格式（即key1=value1&key2=value2…）拼接成字符串string1：
        String signValue = "jsapi_ticket=" + ticket + "&noncestr=" + nonceStr + "×tamp=" + timeStamp + "&url=" + url;
        String signature = DigestUtil.sha1Hex(signValue);
        return signature;
    }
}
