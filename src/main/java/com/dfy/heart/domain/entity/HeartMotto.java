package com.dfy.heart.domain.entity;

import java.io.Serializable;

public class HeartMotto implements Serializable {
    private Integer mottoId;

    private String mottoText;

    private Integer mottoStatus;

    private static final long serialVersionUID = 1L;

    public Integer getMottoId() {
        return mottoId;
    }

    public void setMottoId(Integer mottoId) {
        this.mottoId = mottoId;
    }

    public String getMottoText() {
        return mottoText;
    }

    public void setMottoText(String mottoText) {
        this.mottoText = mottoText == null ? null : mottoText.trim();
    }

    public Integer getMottoStatus() {
        return mottoStatus;
    }

    public void setMottoStatus(Integer mottoStatus) {
        this.mottoStatus = mottoStatus;
    }
}