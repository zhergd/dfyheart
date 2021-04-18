package com.dfy.heart.service.impl;

import com.dfy.heart.dao.HeartAccessMapper;
import com.dfy.heart.dao.HeartMottoMapper;
import com.dfy.heart.dao.HeartUserMapper;
import com.dfy.heart.domain.common.Response;
import com.dfy.heart.domain.entity.*;
import com.dfy.heart.domain.request.AddAccessRequest;
import com.dfy.heart.domain.request.GetMottoRequest;
import com.dfy.heart.service.ICommonService;
import com.dfy.heart.util.BeanMapperUtil;
import com.dfy.heart.util.ResponseUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

/**
 * @author zhangzuhao
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
        try {
            HeartAccess heartAccess = BeanMapperUtil.map(addAccessRequest, HeartAccess.class);
            heartAccess.setAccessTime(System.currentTimeMillis());
            heartAccessMapper.insertSelective(heartAccess);
            return responseUtil.buildSuccessResponse(true);
        } catch (Exception e) {
            System.out.println(e);
            return responseUtil.buildSuccessResponse(false);
        }
    }

    @Override
    public Response<String> getMotto(GetMottoRequest getMottoRequest) {

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
}
