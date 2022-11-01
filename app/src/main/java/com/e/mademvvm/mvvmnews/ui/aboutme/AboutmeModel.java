package com.e.mademvvm.mvvmnews.ui.aboutme;

import com.e.mademvvm.mvvmnews.bean.Aboutme;
import com.e.mademvvm.mvvmnews.bean.BaseReqData;
import com.e.mademvvm.mvvmnews.bean.loginbean.Reqbean;
import com.e.mademvvm.mvvmnews.bean.loginbean.UserBean;
import com.e.mademvvm.repository.AboutmeRepository;
import com.e.mademvvm.repository.LoginRepository;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

public  class AboutmeModel {
    private MutableLiveData<Aboutme> reqbeanMutableLiveData = new MutableLiveData<>();
//    public LiveData<BaseReqData<Aboutme>> loginLiveData = Transformations.switchMap
//            (reqbeanMutableLiveData, new Function<Reqbean, LiveData<BaseReqData<Aboutme>>>() {
//        @Override
//        public LiveData<BaseReqData<Aboutme>> apply(Reqbean input) {
//
//            BaseReqData baseReqData = new BaseReqData();
//
//            return AboutmeRepository.getaboutme();
//        }
//    });
}
