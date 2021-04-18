package com.dfy.heart.domain.common;

import com.dfy.heart.constants.ResponseCode;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhangzuhao
 * @Description: 带扩展分页
 * @date 2020/9/21 11:53
 */
public class PageExResponse<T, K> implements Serializable {
    @ApiModelProperty("code")
    private int code;
    @ApiModelProperty("msg")
    private String msg;
    @ApiModelProperty("请求Id")
    private String requestId;
    @ApiModelProperty("第几页")
    private int pageNum;
    @ApiModelProperty("每页条数")
    private int pageSize;
    @ApiModelProperty("总页数")
    private int pages;
    @ApiModelProperty("总条数")
    private int total;
    @ApiModelProperty("当前页的数据")
    private List<T> data;
    @ApiModelProperty("扩展")
    private K extend;

    @ApiModelProperty("截止时间")
    private long pageDendline;

    @ApiModelProperty("是否有下一页")
    private boolean hasNextPage;

    @ApiModelProperty("系统时间")
    private long currentTimeMillis;

    public long getCurrentTimeMillis() {
        return currentTimeMillis;
    }

    public void setCurrentTimeMillis(long currentTimeMillis) {
        this.currentTimeMillis = currentTimeMillis;
    }

    public long getPageDendline() {
        return pageDendline;
    }

    public void setPageDendline(long pageDendline) {
        this.pageDendline = pageDendline;
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

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
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

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public K getExtend() {
        return extend;
    }

    public void setExtend(K extend) {
        this.extend = extend;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public boolean success() {
        return this.code == ResponseCode.SUCCESS.getCode();
    }

}
