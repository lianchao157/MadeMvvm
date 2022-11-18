package com.e.mademvvm.mvvmnews.http.apiservice;

import android.content.Context;

import com.blankj.utilcode.utils.NetworkUtils;
import  com.e.mademvvm.config.HttpConfig;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import   com.e.mademvvm.BaseApplication;
/***
 * 请求复制构建者模式
 *         * 默认校验token 不忽略https校验
 */

public  class RetrofitServiceBuilder {
    private  static Context mContext;
    private static OkHttpClient client;
//    HttpLoggingInterceptor interceptor;


    /***
     * 创建对象
     */
    public  static  <T>  T createService(final  Class<T> clazz){
        mContext = BaseApplication.getContext();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                System.out.println("信息!!!!!!!!"+message);
               CreateData(message);
//              new ErrotMessageOnclick() {
//                    @Override
//                    public String ErrorMessage() {
//                        return message;
//                    }
//
//                };
            }
        });
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .addInterceptor(interceptor).connectTimeout(3, TimeUnit.SECONDS)
                .readTimeout(3, TimeUnit.SECONDS)
                .writeTimeout(3, TimeUnit.SECONDS)
                .addInterceptor(interceptor);

        client = builder.build();

        if (!NetworkUtils.isConnected(mContext)) {
            return null;
        }

        Retrofit retrofit = new Retrofit.Builder()

//                .baseUrl(HttpConfig.BASE_API)
                .baseUrl(HttpConfig.BASE_APIBYmySelef)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        T service = (T) retrofit.create(clazz);

        return service;


    }

    public static void CreateData(String message) {
        System.out.println("!!!!!!!!!!ffffffffffffffff"+message);
    }


//    public
//      interface ErrotMessageOnclick {
//        public abstract String ErrorMessage();

//        public abstract String SetMeeage();
//    }


}
