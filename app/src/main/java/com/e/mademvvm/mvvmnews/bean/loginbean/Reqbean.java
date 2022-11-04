package com.e.mademvvm.mvvmnews.bean.loginbean;
/**
        * @author huanglinqing
        * @project MvvmNews
        * @date 2020/5/26
        * @desc 请求数据实体
        */
public class Reqbean {
    private int code;

    private String msg;

    private Data data;

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
    public void setData(Data data){
        this.data = data;
    }
    public Data getData(){
        return this.data;
    }
}
