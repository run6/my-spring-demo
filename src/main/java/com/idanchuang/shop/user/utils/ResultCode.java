package com.idanchuang.shop.user.utils;

public enum ResultCode implements IErrorCode {
    SUCCESS(0,"操作成功"),
    FAILED(500, "操作失败"),
    NOT_FOUND(404, "资源不存在"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    FORBIDDEN(403, "没有相关权限");

    private long code;
    private String message;
    ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public long getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
