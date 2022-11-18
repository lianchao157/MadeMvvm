package com.e.mademvvm.repository;


import android.util.Log;

import com.e.mademvvm.mvvmnews.bean.ProjectRepoModel;
import com.e.mademvvm.mvvmnews.bean.loginbean.Reqbean;
import com.e.mademvvm.mvvmnews.bean.loginbean.UserBean;
import com.e.mademvvm.mvvmnews.bean.regin.ReginUser;
import com.e.mademvvm.mvvmnews.bean.regin.User;
import com.e.mademvvm.mvvmnews.http.apiservice.ApiServices;
import com.e.mademvvm.mvvmnews.http.apiservice.BaseSubscriber;
import com.e.mademvvm.mvvmnews.http.apiservice.RetrofitServiceBuilder;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/***
 * z注册的网络请求
 */
public class ReginUserRepository  {
    private static final String TAG = "reginuserRepository";



    public  static  MutableLiveData<ReginUser> reginuser(String Userid, String password, String ps){
        ApiServices apiServices = RetrofitServiceBuilder.createService(ApiServices.class);
        final MutableLiveData<ReginUser> mutableLiveData = new MutableLiveData<>();
        if (apiServices != null) {
            apiServices.regin(Userid, password)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new BaseSubscriber<ReginUser>() {
                        @Override
                        public void onNext(ReginUser user)
                        {
                            mutableLiveData.setValue(user);
                        }

                        @Override
                        public void onError(Throwable e) {

                            Log.d(TAG, "onError: " + e.toString());
                            ReginUser ru=new ReginUser();
                            ru.setMsg(e.toString());

                            mutableLiveData.setValue(ru);
                        }
                    });
        }
        return mutableLiveData;
    }



//    在UI部分
}

