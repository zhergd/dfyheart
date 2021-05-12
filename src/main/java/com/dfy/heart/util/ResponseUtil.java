package com.dfy.heart.util;
import com.dfy.heart.constants.ResponseCode;
import com.dfy.heart.domain.common.ExResponse;
import com.dfy.heart.domain.common.PageExResponse;
import com.dfy.heart.domain.common.PageResponse;
import com.dfy.heart.domain.common.Response;

import org.springframework.stereotype.Component;

import java.util.List;


/**
 * @Description: 响应封装
 * @date 2020/9/21 11:53
 */
@Component
public class ResponseUtil {


    /**
     *
     * @param t
     * @param <T>
     * @return
     */
    public <T> Response<T> buildSuccessResponse(T t) {
        Response<T> response = new Response<>();
        response.setCode(ResponseCode.SUCCESS.getCode());
        response.setMsg(ResponseCode.SUCCESS.getMsg());
        response.setData(t);
        response.setCurrentTimeMillis(System.currentTimeMillis());
        return response;
    }


    /**
     * 失败/错误的响应（里面可以封装失败/错误的数据）
     *
     */
    public <T> Response<T> buildErrorResponse(ResponseCode responseCode,T t){
        Response<T> response = new Response<>();
        response.setCode(responseCode.getCode());
        response.setMsg(responseCode.getMsg());
        response.setData(t);
        response.setCurrentTimeMillis(System.currentTimeMillis());
        return response;
    }


    /**
     * 进行i189转换
     * @param responseCode
     * @return
     */
    public Response buildErrorResponse(ResponseCode responseCode) {
        Response response = new Response();
        response.setCode(responseCode.getCode());
        response.setMsg(responseCode.getMsg());
        response.setCurrentTimeMillis(System.currentTimeMillis());
        return response;
    }

    /**
     *
     * @param pageNum
     * @param pageSize
     * @param pages
     * @param t
     * @param <T>
     * @return
     */
    public <T> PageResponse<T> buildSuccessPageResponse(int pageNum, int pageSize, int pages, int total, List<T> t) {
        PageResponse<T> response = new PageResponse<>();
        response.setCode(ResponseCode.SUCCESS.getCode());
        response.setMsg(ResponseCode.SUCCESS.getMsg());
        response.setPageNum(pageNum);
        response.setPageSize(pageSize);
        response.setPages(pages);
        response.setTotal(total);
        response.setData(t);
        response.setCurrentTimeMillis(System.currentTimeMillis());
        return response;
    }

    public <T, K> PageExResponse<T, K> buildSuccessExPageResponse(int pageNum, int pageSize, int pages, int total, List<T> t, K extend) {
        PageExResponse<T, K> response = new PageExResponse<>();
        response.setCode(ResponseCode.SUCCESS.getCode());
        response.setMsg(ResponseCode.SUCCESS.getMsg());
        response.setPageNum(pageNum);
        response.setPageSize(pageSize);
        response.setPages(pages);
        response.setTotal(total);
        response.setData(t);
        response.setExtend(extend);
        response.setCurrentTimeMillis(System.currentTimeMillis());
        return response;
    }


    public <T, K> PageExResponse<T, K> buildSuccessExPageResponse(int pageNum, int pageSize,
        int pages, int total, List<T> t, K extend, boolean hasNextPage) {
        PageExResponse<T, K> response = buildSuccessExPageResponse(pageNum, pageSize, pages, total,
            t, extend);
        response.setHasNextPage(hasNextPage);
        return response;
    }

    /**
     *
     * @param responseCode
     * @return
     */
    public PageResponse buildErrorPageResponse(ResponseCode responseCode) {
        PageResponse response = new PageResponse();
        response.setCode(responseCode.getCode());
        response.setMsg(responseCode.getMsg());
        response.setCurrentTimeMillis(System.currentTimeMillis());
        return response;
    }

    /**
     *
     * @param code
     * @param msg
     * @return
     */
    public PageResponse buildErrorPageResponse(int code, String msg) {
        PageResponse response = new PageResponse();
        response.setCode(code);
        response.setMsg(msg);
        response.setCurrentTimeMillis(System.currentTimeMillis());
        return response;
    }

    /**
     *
     * @param responseCode
     * @return
     */
    public PageExResponse buildErrorPageExResponse(ResponseCode responseCode) {
        PageExResponse response = new PageExResponse();
        response.setCode(responseCode.getCode());
        response.setMsg(responseCode.getMsg());
        response.setCurrentTimeMillis(System.currentTimeMillis());
        return response;
    }

    /**
     *
     * @param code
     * @param msg
     * @return
     */
    public PageExResponse buildErrorPageExResponse(int code, String msg) {
        PageExResponse response = new PageExResponse();
        response.setCode(code);
        response.setMsg(msg);
        response.setCurrentTimeMillis(System.currentTimeMillis());
        return response;
    }

    /**
     * page response转response
     * @param pageResponse
     * @return
     */
    public Response buildPage2Response(PageResponse pageResponse) {
        Response response = new Response();
        response.setCode(pageResponse.getCode());
        response.setMsg(pageResponse.getMsg());
        response.setData(pageResponse.getData());
        response.setCurrentTimeMillis(System.currentTimeMillis());
        return response;
    }


    /**
     * 进行i189转换
     * @param responseCode
     * @return
     */
    public ExResponse buildSuccessExResponse(ResponseCode responseCode) {
        ExResponse response = new ExResponse();
        response.setCode(ResponseCode.SUCCESS.getCode());
        response.setMsg(ResponseCode.SUCCESS.getMsg());
        response.setCurrentTimeMillis(System.currentTimeMillis());
        return response;
    }

    /**
     * 不做转换，直接返回，由于接受back的错误信息（已转i18n）
     * @param code
     * @param msg
     * @return
     */
    public ExResponse buildErrorExResponse(int code, String msg) {
        ExResponse response = new ExResponse();
        response.setCode(code);
        response.setMsg(msg);
        response.setCurrentTimeMillis(System.currentTimeMillis());
        return response;
    }
}
