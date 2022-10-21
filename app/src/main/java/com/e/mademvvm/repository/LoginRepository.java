package com.e.mademvvm.repository;

//import com.e.createmcvp.config.HttpConfig;
//import com.e.createmcvp.config.UserConfig;
//import com.e.createmcvp.mvvmnews.bean.BaseReqData;
//import com.e.createmcvp.mvvmnews.bean.loginbean.UserBean;

import com.e.mademvvm.config.HttpConfig;
import com.e.mademvvm.config.UserConfig;
import com.e.mademvvm.mvvmnews.bean.BaseReqData;
import com.e.mademvvm.mvvmnews.bean.loginbean.UserBean;

import androidx.lifecycle.MutableLiveData;

public class LoginRepository {

    public static MutableLiveData<BaseReqData<UserBean>> login(String username, String password) {
        BaseReqData baseReqData = new BaseReqData();
        if (username.equals(UserConfig.USER_NAME) && password.equals(UserConfig.USER_PASS)) {
            UserBean userBean = new UserBean();
            userBean.setNickName(username);
            userBean.setPassword(password);
            baseReqData.setBody(userBean);
            baseReqData.setMsg("登陆成工");
            baseReqData.setStatue(HttpConfig.REQUEST_OK);

        } else {
            baseReqData.setMsg("用户名不正确");
            baseReqData.setStatue(HttpConfig.REQUEST_FAILED);


        }  MutableLiveData<BaseReqData<UserBean>> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(baseReqData);
        return mutableLiveData;

    }
}
