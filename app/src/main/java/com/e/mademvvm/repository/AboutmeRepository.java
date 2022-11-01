package com.e.mademvvm.repository;

import com.e.mademvvm.config.HttpConfig;
import com.e.mademvvm.config.UserConfig;
import com.e.mademvvm.mvvmnews.bean.Aboutme;
import com.e.mademvvm.mvvmnews.bean.BaseReqData;
import com.e.mademvvm.mvvmnews.bean.loginbean.UserBean;

import androidx.lifecycle.MutableLiveData;

public
class AboutmeRepository {
    public static MutableLiveData<BaseReqData<Aboutme>> getaboutme(){
        BaseReqData baseReqData = new BaseReqData();

            Aboutme userBean = new Aboutme();
            baseReqData.setBody(userBean);
            baseReqData.setMsg("登陆成工");
            baseReqData.setStatue(HttpConfig.REQUEST_OK);

            baseReqData.setMsg("用户名不正确");
            baseReqData.setStatue(HttpConfig.REQUEST_FAILED);


        MutableLiveData<BaseReqData<Aboutme>> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(baseReqData);
        return mutableLiveData;
    }
}
