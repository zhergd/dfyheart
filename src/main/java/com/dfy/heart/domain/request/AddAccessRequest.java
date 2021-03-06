package com.dfy.heart.domain.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @description:
 * @date: 2021/4/17 15:08
 */
public class AddAccessRequest implements Serializable {


    private Integer accessType;

    @ApiModelProperty("sign")
    private String sign;

    @ApiModelProperty("time")
    private Long time;

    private static final long serialVersionUID = 1L;

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

    public Integer getAccessType() {
        return accessType;
    }

    public void setAccessType(Integer accessType) {
        this.accessType = accessType;
    }
}
