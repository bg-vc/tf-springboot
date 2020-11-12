package com.tf.common.model;

import com.alibaba.fastjson.JSON;
import com.tf.common.enums.ResultCode;
import lombok.Data;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;

/**
 * Author:       VinceChen
 * Date:         2020-11-12 09:58
 * Description:
 */
@Data
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Result<T> implements Serializable {

    private int code;

    private String msg;

    private T data;

    public Result() {
    }

    public Result(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
    }

    public Result(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.data = data;
    }

    public Result setResult(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        return this;
    }

    public int getCode() {
        return this.code;
    }

    public Result setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return this.msg;
    }

    public Result setMsg(String message) {
        this.msg = message;
        return this;
    }

    public T getData() {
        return this.data;
    }

    public Result setData(T data) {
        this.data = data;
        return this;
    }

    public boolean isSuccess() {
        return this.code == ResultCode.SUCCESS.getCode();
    }

    public String toString() {
        return JSON.toJSONString(this);
    }
}
