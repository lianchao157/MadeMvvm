package com.e.mademvvm.mvvmnews.bean.regin;

import java.io.Serializable;

public
class User implements Serializable {
    public String getUsernaem() {
        return Usernaem;
    }

    public void setUsernaem(String usernaem) {
        Usernaem = usernaem;
    }

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps;
    }

    public User() {
    }

    public User(String usernaem, String ps, String trueps) {
        Usernaem = usernaem;
        this.ps = ps;
        this.trueps = trueps;
    }

    public String getTrueps() {
        return trueps;
    }

    public void setTrueps(String trueps) {
        this.trueps = trueps;
    }

    private  String  Usernaem;
    private  String  ps;
    private String trueps;
}
