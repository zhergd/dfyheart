package com.dfy.heart.constants;

/**
 * @author zhangzuhao
 * @description:
 * @date: 2020/9/21 17:34
 */
public enum ResponseCode {
    /**
     * 成功
     */
    SUCCESS(0, "success"),

    /**
     * 业务异常
     */
    FAILURE(-1, "业务异常"),

    //************************ 系统错误码 10 ************************
    SERVER_INNER_ERROR(1001, "服务器异常，请稍后再试"),
    PARAMETER_ERROR(1002, "提交参数不符合规范"),
    DING_DING_ACCESS_ERROR(1003, "获取accessToken失败"),
    TOKEN_ILLEGAL(1004, "token非法，请重新登录"),
    TOKEN_EXPIRE(1005, "token失效，请重新登录"),
    TOKEN_FAULT(1006, "未登录，无权限访问"),
    CHECK_SIGN_FAIL(1007, "验签失败,请输入正确的sign"),


    ;

    private int code;

    private String msg;

    ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
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
}
