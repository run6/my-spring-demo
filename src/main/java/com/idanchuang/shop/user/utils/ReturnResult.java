package com.idanchuang.shop.user.utils;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;

@Data
public class ReturnResult<T> implements Serializable {

    private static final int SYSTEM_ERROR = 5001;
    private static final int SUCCESS = 0;

    // 提示msg
    private String message = "操作成功";
    //业务代码
    private Integer code = 0;
    // 返回数据对象
    private T result;
    // 时间戳
    private long timestamp = System.currentTimeMillis();

    private static final HashMap<Integer, String> resultMsg = new HashMap<>();

    static {
        resultMsg.put(SYSTEM_ERROR, "系统异常,请重试");
        resultMsg.put(SUCCESS, "操作成功");
    }

    private static String getResultMsgByCode(Integer code) {
        var msg = resultMsg.get(code);
        if (!msg.isEmpty()) {
            return msg;
        } else {
            return "服务器与地球失去联系了~~~~";
        }
    }


    public ReturnResult<T> success(String message) {
        return this;
    }


    public static ReturnResult<Object> ok(String msg) {
        ReturnResult<Object> r = new ReturnResult<>();
        r.setMessage(msg);
        return r;
    }

    public static ReturnResult<Object> ok(Object data) {
        ReturnResult<Object> r = new ReturnResult<>();
        r.setResult(data);
        return r;
    }

    public static ReturnResult<Object> error(int code, String msg) {
        ReturnResult<Object> r = new ReturnResult<>();
        r.setCode(code);
        r.setMessage(msg);
        return r;
    }

    public static ReturnResult<Object> error(int code) {
        ReturnResult<Object> r = new ReturnResult<>();
        r.setCode(code);
        r.setMessage(getResultMsgByCode(code));
        return r;
    }


    public static ReturnResult<Object> error(String msg) {
        return error(SYSTEM_ERROR, msg);
    }
}
