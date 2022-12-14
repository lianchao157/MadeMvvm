package com.e.mademvvm.repository;

//import com.e.createmcvp.config.HttpConfig;
//import com.e.createmcvp.config.UserConfig;
//import com.e.createmcvp.mvvmnews.bean.BaseReqData;
//import com.e.createmcvp.mvvmnews.bean.loginbean.UserBean;

import android.util.Log;

import com.e.mademvvm.config.HttpConfig;
import com.e.mademvvm.config.UserConfig;
import com.e.mademvvm.mvvmnews.bean.BaseReqData;
import com.e.mademvvm.mvvmnews.bean.NewBean;
import com.e.mademvvm.mvvmnews.bean.loginbean.Data;
import com.e.mademvvm.mvvmnews.bean.loginbean.Reqbean;
import com.e.mademvvm.mvvmnews.bean.loginbean.UserBean;
import com.e.mademvvm.mvvmnews.http.apiservice.ApiServices;
import com.e.mademvvm.mvvmnews.http.apiservice.BaseSubscriber;
import com.e.mademvvm.mvvmnews.http.apiservice.RetrofitServiceBuilder;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class LoginRepository {
    private static final String TAG = "LoginRepository";


    public static MutableLiveData<Reqbean> login(String username, String password) {
        ApiServices apiServices = RetrofitServiceBuilder.createService(ApiServices.class);
        final MutableLiveData<Reqbean> mutableLiveDataReqbean = new MutableLiveData<>();
        if (apiServices != null) {
            apiServices.getlogin(username, password)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new BaseSubscriber<Reqbean>() {
                        @Override
                        public void onNext(Reqbean reqbean) {
                            Log.d(TAG, "onNext: 在这里"+reqbean.getCode());
                            Log.d(TAG, "onNext: 在这里");
                            mutableLiveDataReqbean.setValue(reqbean);
                        }

                        @Override
                        public void onError(Throwable e) {
                            Reqbean reqbean=new Reqbean();
                            reqbean.setMsg(""+e.toString()+e.getMessage());
                            mutableLiveDataReqbean.setValue(reqbean);
                        }
                    });
        }
        return mutableLiveDataReqbean;
    }

}

