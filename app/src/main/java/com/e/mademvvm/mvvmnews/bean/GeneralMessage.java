package com.e.mademvvm.mvvmnews.bean;

import com.alibaba.fastjson.JSON;

import java.util.List; /***
 * 返回封装的头部
 * code
 * message
 * data
 */
public class GeneralMessage {
    public GeneralMessage(String message, T data, String code) {
        Message = message;
        Data = data;
        Code = code;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public Object getData() {
        return Data;
    }

    public void setData(T data) {
        Data = data;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    private String Message;
    private Object Data;
    private String Code;
    @Override
    public String toString() {

        return JSON.toJSONString(this);
    }
}
