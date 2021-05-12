package com.dfy.heart.domain.request;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class GetWxConfigRequest implements Serializable {

    public static final long serialVersionUID = 1L;

    @ApiModelProperty("url")
    private String url;

    @ApiModelProperty("sign")
    private String sign;

    @ApiModelProperty("time")
    private Long time;

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
