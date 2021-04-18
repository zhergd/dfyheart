package com.dfy.heart.domain.entity;

import java.io.Serializable;

public class HeartUser implements Serializable {
    private Integer userId;

    private String userName;

    private String userIp;

    private Integer mottoId;

    private Long createTime;

    private static final long serialVersionUID = 1L;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp == null ? null : userIp.trim();
    }

    public Integer getMottoId() {
        return mottoId;
    }

    public void setMottoId(Integer mottoId) {
        this.mottoId = mottoId;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}