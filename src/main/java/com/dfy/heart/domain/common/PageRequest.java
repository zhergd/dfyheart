package com.dfy.heart.domain.common;

import io.swagger.annotations.ApiModelProperty;

/**
 * 分页请求参数
 * @author zhangzuhao
 * @date 2020/9/28 17:17
 */
public class PageRequest {

    @ApiModelProperty("查询范围开始时间,可以空")
    private Long startTime;

    @ApiModelProperty("查询范围结束时间,可以空")
    private Long endTime;

    @ApiModelProperty("页数(从1开始),不能空")
    private int pageNum = 1;

    @ApiModelProperty("每页条数,不能空")
    private int pageSize = 20;

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
