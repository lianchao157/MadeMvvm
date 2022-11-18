package com.e.mademvvm.mvvmnews.bean.regin;

import com.e.mademvvm.mvvmnews.bean.loginbean.Data;

/***
 * 实现注册的反应类
 */
public  class ReginUser {
    private int code;

    private String msg;

    private User data;

    public void setCode(int code){
        this.code = code;
    }
    public int getCode(){
        return this.code;
    }
    public void setMsg(String msg){
        this.msg = msg;
    }
    public String getMsg(){
        return this.msg;
    }
    public void setData(User data){
        this.data = data;
    }
    public User getData(){
        return this.data;
    }
}
