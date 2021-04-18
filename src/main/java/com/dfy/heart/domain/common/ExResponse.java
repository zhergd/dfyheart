package com.dfy.heart.domain.common;



import com.dfy.heart.constants.ResponseCode;

import java.io.Serializable;

/**
 * @author zhangzhao
 * @Description: 响应
 * @date 2020/9/21 11:53
 */
public class ExResponse<T, K> implements Serializable {

    private int code;

    private String msg;

    private T data;

    private K extend;

    private String requestId;

    private long currentTimeMillis;

    public long getCurrentTimeMillis() {
        return currentTimeMillis;
    }

    public void setCurrentTimeMillis(long currentTimeMillis) {
        this.currentTimeMillis = currentTimeMillis;
    }

    public K getExtend() {
        return extend;
    }

    public void setExtend(K extend) {
        this.extend = extend;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean success() {
        return this.code == ResponseCode.SUCCESS.getCode();
    }


    @Override
    public String toString() {
        return "Response{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", requestId='" + requestId + '\'' +
                '}';
    }
}
