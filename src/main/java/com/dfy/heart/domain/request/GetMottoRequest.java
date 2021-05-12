package com.dfy.heart.domain.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @description:
 * @date: 2021/4/17 15:38
 */
@ApiModel(value = "获取格言请求参数")
public class GetMottoRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户名称")
    private String userName;

    @ApiModelProperty(value = "用户ip")
    private String userIp;

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }
}
