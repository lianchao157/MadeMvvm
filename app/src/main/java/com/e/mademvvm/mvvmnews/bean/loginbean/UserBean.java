package com.e.mademvvm.mvvmnews.bean.loginbean;

import java.io.Serializable;

public class UserBean implements Serializable {
    private String username;

    private String usertel;

    public UserBean(String userName, String userPass) {

    }

    public UserBean() {

    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsertel(String usertel) {
        this.usertel = usertel;
    }

    public String getUsertel() {
        return this.usertel;
    }
}
