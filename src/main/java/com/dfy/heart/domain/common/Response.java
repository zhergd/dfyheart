package com.dfy.heart.domain.common;


import com.dfy.heart.constants.ResponseCode;

import java.io.Serializable;

/**
 * @Description: 响应
 * @date 2020/9/17 14:10
 */
public class Response<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private int code;

    private String msg;

    private T data;

    private long currentTimeMillis;

    public long getCurrentTimeMillis() {
        return currentTimeMillis;
    }

    public void setCurrentTimeMillis(long currentTimeMillis) {
        this.currentTimeMillis = currentTimeMillis;
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
                '}';
    }
}
