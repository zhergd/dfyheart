package com.dfy.heart.domain.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author zhangzuhao
 * @description:
 * @date: 2021/4/17 15:08
 */
@ApiModel(value = "触发埋点请求参数")
public class AddAccessRequest implements Serializable {


    @ApiModelProperty("埋点类型 1首页 2次页(开启拾年之旅) 3预览 4开启高光时刻 5输入名字")
    private Integer accessType;

    private static final long serialVersionUID = 1L;

    public Integer getAccessType() {
        return accessType;
    }

    public void setAccessType(Integer accessType) {
        this.accessType = accessType;
    }
}
