package com.idanchuang.shop.user.utils;

import lombok.Data;

import java.io.Serializable;

@Data
public class ReturnResult<T> implements Serializable {

    private String message = "操作成功";
    private long code = 0;
    private T data;
    private long timestamp = System.currentTimeMillis();

    private ReturnResult(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    private ReturnResult(){}

    public static ReturnResult success() {
        return new ReturnResult();
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> ReturnResult<T> success(T data) {
        return new ReturnResult<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    public static ReturnResult<Object> error(long code, String msg) {
        ReturnResult<Object> r = new ReturnResult<>();
        r.setCode(code);
        r.setMessage(msg);
        return r;
    }

    public static ReturnResult<Object> error(long code) {
        ReturnResult<Object> r = new ReturnResult<>();
        r.setCode(code);
        r.setMessage("(⊙o⊙)服务器好像出了点问题,请重试一下吧~");
        return r;
    }


    public static ReturnResult<Object> error(String msg) {
        return error(ResultCode.FAILED.getCode(), msg);
    }
}
