package com.e.mademvvm.mvvmnews.bean.loginbean;

public
class Data {
    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    private  UserBean userBean;
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    public Data() {
    }


    private String token;
}
