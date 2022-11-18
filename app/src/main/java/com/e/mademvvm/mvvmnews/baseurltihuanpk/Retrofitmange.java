package com.e.mademvvm.mvvmnews.baseurltihuanpk;

import android.content.Context;

import com.blankj.utilcode.utils.NetworkUtils;
import com.e.mademvvm.BaseApplication;
import com.e.mademvvm.config.HttpConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public
class Retrofitmange {
    static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            //直接添加这个HxCallFactory 即可
            //里面的参数是我们全局的BaseURL
            .callFactory(new HxCallFactory("https://api.github.com/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build();
//    原文链接：https://blog.csdn.net/u013762572/article/details/88910098
}
