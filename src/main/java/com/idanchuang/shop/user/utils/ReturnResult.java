package com.idanchuang.shop.user.utils;

import org.apache.catalina.connector.Response;
import java.util.HashMap;

public class ReturnResult {

    private static final int SYSTEM_ERROR = 5001;
    private static final int SUCCESS = 0;



    private static final HashMap<Integer,String> resultMsg = new HashMap<>();
    static {
        resultMsg.put(SYSTEM_ERROR,"系统异常,请重试");
        resultMsg.put(SUCCESS,"操作成功");
    }

    private static String getResultMsgByCode(Integer code){
        var msg = resultMsg.get(code);
        if (!msg.isEmpty()) {
            return msg;
        }else {
            return  "服务器与地球失去联系了~~~~";
        }
    }

    private static HashMap creat(Integer code,String msg,HashMap data){
        var result = new HashMap<>();

        result.put("code",code);
        result.put("msg",msg);
        result.put("data",data);
        return result;
    }

    private static HashMap creat(Integer code, String msg) {
        var result = new HashMap<>();

        result.put("code",code);
        result.put("msg",msg);
        return result;
    }


    public static HashMap success(){
        String msg = getResultMsgByCode(SUCCESS);
        return creat(SUCCESS,msg,new HashMap());
    }

    public static HashMap success(HashMap data){
        String msg = getResultMsgByCode(SUCCESS);
        return creat(SUCCESS,msg,data);
    }

    public static HashMap error(){
        String msg = getResultMsgByCode(SYSTEM_ERROR);
        return creat(SYSTEM_ERROR,msg);
    }

    public static HashMap error(Integer code) {
        String msg = getResultMsgByCode(code);
        return creat(code,msg);
    }


    public static HashMap error(Integer code,String msg){
        return creat(code,msg);
    }

}
