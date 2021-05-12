package com.dfy.heart.domain.response;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

public class GetWxConfigResponse implements Serializable {

    public static final long serialVersionUID = 1L;

    @ApiModelProperty("appId")
    private String appId;
    @ApiModelProperty("timestamp")
    private String timestamp;
    @ApiModelProperty("nonceStr")
    private String nonceStr;
    @ApiModelProperty("signature")
    private String signature;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
