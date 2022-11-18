package com.e.mademvvm.repository;

//import com.e.createmcvp.config.HttpConfig;
//import com.e.createmcvp.config.UserConfig;
//import com.e.createmcvp.mvvmnews.bean.BaseReqData;
//import com.e.createmcvp.mvvmnews.bean.loginbean.UserBean;

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
public class ReginUserRepository {
    private static final String TAG = "reginuserRepository";



    public  static  MutableLiveData<User> reginuser(String Userid, String password, String ps){
        final MutableLiveData<User > data = new MutableLiveData<>();
        ApiServices apiServices = RetrofitServiceBuilder.createService(ApiServices.class);
        final MutableLiveData<User> mutableLiveData = new MutableLiveData<>();
        if (apiServices != null) {
            apiServices.regin(Userid, password)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new BaseSubscriber<User>() {
                        @Override
                        public void onNext(User user) {
                            mutableLiveData.setValue(user);
                        }

                        @Override
                        public void onError(Throwable e) {

                            Log.d(TAG, "onError: " + e.toString());
                        }
                    });
        }
        return mutableLiveData;
    }



//    在UI部分
}

