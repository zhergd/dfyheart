package com.dfy.heart.domain.response;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author zhangzuhao
 * @description:
 * @date: 2021/4/16 9:55
 */
public class CoordinatesResponse implements Serializable {

    public static final long serialVersionUID = 1L;

    @ApiModelProperty("x轴坐标")
    private Double XCoordinate;

    @ApiModelProperty("x轴坐标")
    private Double YCoordinate;

    public CoordinatesResponse() {

    }

    public CoordinatesResponse(Double XCoordinate, Double YCoordinate) {
        this.XCoordinate = XCoordinate;
        this.YCoordinate = YCoordinate;
    }

    public Double getXCoordinate() {
        return XCoordinate;
    }

    public void setXCoordinate(Double XCoordinate) {
        this.XCoordinate = XCoordinate;
    }

    public Double getYCoordinate() {
        return YCoordinate;
    }

    public void setYCoordinate(Double YCoordinate) {
        this.YCoordinate = YCoordinate;
    }
}
