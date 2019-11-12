package com.idanchuang.shop.user;

import java.util.HashMap;

public class ReturnResult {
    public static HashMap creat(Integer code,String msg,HashMap data){
        var result = new HashMap<>();

        result.put("code",code);
        result.put("msg",msg);
        result.put("data",data);
        return result;
    }
}
