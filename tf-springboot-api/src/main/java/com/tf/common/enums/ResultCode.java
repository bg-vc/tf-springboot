package com.tf.common.enums;

/**
 * Author:       VinceChen
 * Date:         2020-11-12 09:54
 * Description:
 */
public enum ResultCode {
    SUCCESS(0, "成功"),
    INTERNAL_SERVER_ERROR(1, "服务器内部错误"),
    ERR_PARAM(2, "请求参数错误"),
    ERR_TOKEN_EMPTY(3, "token为空"),
    ERR_TOKEN_INVALID(4, "token无效或过期"),
    ERR_SERVICE_NOT_FOUND(5, "服务不存在"),

    ;

    private Integer code;

    private String msg;

    ResultCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }
}
