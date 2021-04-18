package com.dfy.heart.domain.entity;

import java.io.Serializable;

public class HeartAccess implements Serializable {
    private Integer accessId;

    private Integer accessType;

    private Long accessTime;

    private static final long serialVersionUID = 1L;

    public Integer getAccessId() {
        return accessId;
    }

    public void setAccessId(Integer accessId) {
        this.accessId = accessId;
    }

    public Integer getAccessType() {
        return accessType;
    }

    public void setAccessType(Integer accessType) {
        this.accessType = accessType;
    }

    public Long getAccessTime() {
        return accessTime;
    }

    public void setAccessTime(Long accessTime) {
        this.accessTime = accessTime;
    }
}