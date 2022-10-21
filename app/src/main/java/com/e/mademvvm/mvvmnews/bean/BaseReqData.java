package com.e.mademvvm.mvvmnews.bean;

/**
 * 数据体
 */
public  class BaseReqData<T>  {
    private String statue;
    private String msg;
    private T body;

    public String getStatue() {
        return statue;
    }

    public String getMsg() {
        return msg;
    }

    public T getBody() {
        return body;
    }

    public void setStatue(String statue) {
        this.statue = statue;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
