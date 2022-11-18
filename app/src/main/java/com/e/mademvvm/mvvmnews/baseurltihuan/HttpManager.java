package com.e.mademvvm.mvvmnews.baseurltihuan;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import android.util.Log;


import com.blankj.utilcode.utils.LogUtils;
import com.e.mademvvm.config.Constants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
//import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
//import retrofit2.converter.gson.GsonConverterFactory;
//import rx.Observable;
//import rx.android.schedulers.AndroidSchedulers;
//import rx.functions.Func1;
//import rx.schedulers.Schedulers;
/****
 * https://www.likecs.com/show-205001997.html#sc=4629.33349609375
 */
import retrofit2.adapter.rxjava2.*;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
//这个包下多base url 使用
public class HttpManager {
    public static final String TAG = "HttpManager-------";

    /*超时设置*/
    private static final int DEFAULT_TIMEOUT = 6;
    private RemoteService httpService;
    private volatile static HttpManager INSTANCE;

    //构造方法私有
    private HttpManager() {

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                LogUtils.d(TAG,message);
            }
        });
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder builder = new OkHttpClient().newBuilder()
                .connectTimeout(5, TimeUnit.SECONDS)  //设置超时时间 10s
                .readTimeout(5, TimeUnit.SECONDS)     //设置读取超时时间
                .writeTimeout(5, TimeUnit.SECONDS)   //设置写入超时时间
                .addInterceptor(httpLoggingInterceptor)//添加一个拦截器
                .addInterceptor(new MoreBaseUrlInterceptor());

        OkHttpClient okClient = builder.build();

//        Retrofit retrofit = new Retrofit.Builder()
//                .addConverterFactory(GsonConverterFactory.create(IJson.gson)) // 使用Gson作为数据转换器
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) // 使用RxJava作为回调适配器
//                .client(okClient)
//                .baseUrl(Constants.Base.BASE_URL_RELEASE)//获取 最终的base url
//                /*.baseUrl(App.getInstance().getRealUrl())//此处选择 api 的真实网址*/
//                .build();
//        httpService = retrofit.create(RemoteService.class);
    }

    //获取单例
    public static HttpManager getInstance() {
        if (INSTANCE == null) {
            synchronized (HttpManager.class) {
                if (INSTANCE == null) {
                    INSTANCE = new HttpManager();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * 处理http请求
     *
     * @param basePar 封装的请求数据
     */
//    public void doHttpDeal(BaseEntity basePar) {
//        //if (basePar.isShowProgress())
//        ProgressSubscriber subscriber = new ProgressSubscriber(basePar.getListener()
//                , basePar.getContext()
//                , basePar.isShowProgress()
//                , basePar.isCancel()
//                , basePar.isShowError()
//                , basePar.getMsg());
//        basePar.getObservable(httpService)
//                /*失败后的retry配置*/
//                .retryWhen(new RetryWhenNetworkException())
//                /*生命周期管理*/
//                .compose(basePar.getTransformer())
////                .map(new_icon ServerResponseFunc<String>())//拦截服务器返回的错误
//                .onErrorResumeNext(new HttpResponseFunc<String>()) //HttpResultFunc（）为拦截onError事件的拦截器
//                /*http请求线程*/
//                .subscribeOn(Schedulers.io())
//                .unsubscribeOn(Schedulers.io())
//                /*回调线程*/
//                .observeOn(AndroidSchedulers.mainThread())
//                /*结果判断*/
////                .map(basePar)
//                .subscribe(subscriber);
//    }

//    private class HttpResponseFunc<T> implements Func1<Throwable, Observable<T>> {
//        @Override
//        public Observable<T> call(Throwable throwable) {
//            Log.e(TAG,"----这是啥异常？--");
//            throwable.printStackTrace();
//            return Observable.error(ExceptionEngine.handleException(throwable)); //ExceptionEngine为处理异常的驱动器
//        }
//    }

}
