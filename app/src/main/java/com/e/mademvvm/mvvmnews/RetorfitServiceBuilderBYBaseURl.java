package com.e.mademvvm.mvvmnews;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Log;

import com.e.mademvvm.BaseApplication;
import com.e.mademvvm.mvvmnews.http.apiservice.BaseUrlInterceptor;
import com.e.mademvvm.utils.NetworkUtil;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

import static com.e.mademvvm.BaseApplication.context;
/***
 * 多base  url
 */
public
class RetorfitServiceBuilderBYBaseURl {
    //设置缓存目录
    //拦截器
    File cacheFile = new File(BaseApplication.getContext().getCacheDir(), "cache");
    Cache cache = new Cache(cacheFile, 1024 * 1024 * 100); //100Mb
    OkHttpClient client = new OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.MILLISECONDS)
            .connectTimeout(60, TimeUnit.MILLISECONDS)
            .addInterceptor(mRewriteCacheControlInterceptor)//没网的情况下
            .addNetworkInterceptor(mRewriteCacheControlInterceptor)//有网的情况下
            .addInterceptor(new BaseUrlInterceptor())
            .addInterceptor(getHttpLoggingInterceptor())
            .cache(cache)
            .build();
    /***
     *
     * https://zhuanlan.zhihu.com/p/30168137
     * 日志拦截器
     */
    public static HttpLoggingInterceptor getHttpLoggingInterceptor() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(
                new HttpLoggingInterceptor.Logger() {

                    @Override
                    public void log(String message) {
                        Log.e("OkHttp", "log = " + message);
                    }

                });
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return loggingInterceptor;
    }



    Interceptor rewriteCacheControlInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Response originalResponse = chain.proceed(request);
            int maxAge = 1 * 60; // 在线缓存在1分钟内可读取 单位:秒
            return originalResponse.newBuilder()
                    .removeHeader("Pragma")// 清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
                    .removeHeader("Cache-Control")
                    .header("Cache-Control", "public, max-age=" + maxAge)
                    .build();
        }
    };

//    //配置拦截器
    Interceptor mRewriteCacheControlInterceptor1 = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Response originalResponse = chain.proceed(request);
            int maxAge = 1 * 60; // 在线缓存在1分钟内可读取 单位:秒
            return originalResponse.newBuilder()
                    .removeHeader("Pragma")// 清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
                    .removeHeader("Cache-Control")
                    .header("Cache-Control", "public, max-age=" + maxAge)
                    .build();
        }
    };




    /**
     * 网络请求log拦截器
     * @return log拦截器对象
     */

//    public static HttpLodggingInterceptor getLogInterceptor(){
//        //设置log拦截器拦截内容
//        HttpLoggingInterceptor.Level level= HttpLoggingInterceptor.Level.BODY;
//        //新建log拦截器
//        HttpLoggingInterceptor loggingInterceptor=new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
//            @Override
//            public void log(String message) {
//                Log.e("------retrofit-------",message);
//            }
//        });
//        loggingInterceptor.setLevel(level);
//        return loggingInterceptor;
//    }

    /**
     * 网络优先数据缓存拦截器
     * @return 拦截器对象
     */
    public static Interceptor cacheInterceptor(final Context context){
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();//获取请求
                //没有网络的时候强制使用缓存
                if (!isNetworkAvailable(context)){
                    request = request.newBuilder()
                            .cacheControl(CacheControl.FORCE_CACHE)
                            .build();
                    Log.e("睚眦","没网读取缓存");
                }
                Response originalResponse = chain.proceed(request);
                if (isNetworkAvailable(context)){
                    return originalResponse.newBuilder()
                            .removeHeader("Pragma")
                            .header("Cache-Control","public,max-age"+0)
                            .build();
                } else {
                    int maxTime = 4*24*60*30;
                    return originalResponse.newBuilder()
                            .removeHeader("Pragma")
                            .header("Cache-Control","public,only-if-cached,max-state="+maxTime)
                            .build();
                }
            }
        };
        return interceptor;
    }

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            //ACCESS_NETWORK_STATE
            NetworkInfo info = connectivity.getActiveNetworkInfo();
            if (info != null && info.isConnected()) {
                // 当前网络是连接的
                if (info.getState() == NetworkInfo.State.CONNECTED) {
                    // 当前所连接的网络可用
                    return true;
                }
            }
        }
        return false;
    }

//    private static OkHttpClient getOkHttpClient(){
//        Cache cache = new Cache(new File(PrepareApplication.getAppContext().getCacheDir(), "HttpCache"), 1024 * 1024 * 100);
//            OkHttpClient okHttpClient = new OkHttpClient.Builder().cache(cache)
//                    .connectTimeout(6, TimeUnit.SECONDS)
//                    .readTimeout(6, TimeUnit.SECONDS)
//                    .writeTimeout(6, TimeUnit.SECONDS)
//                    .addInterceptor(mRewriteCacheControlInterceptor)
//                    .addNetworkInterceptor(mRewriteCacheControlInterceptor)
//                    .addInterceptor(mLoggingInterceptor).build();
//            return okHttpClient;
//    }
private static final long CACHE_STALE_SEC = 60 * 60 * 24 * 4;

    private static final Interceptor mRewriteCacheControlInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            if (!NetworkUtil.isNetworkAvailable(context)) {
                request = request.newBuilder()
                        .cacheControl(CacheControl.FORCE_CACHE)
                        .build();
            }
            Response originalResponse = chain.proceed(request);
            if (NetworkUtil.isNetworkAvailable(context)) {
                //有网的时候读接口上的@Headers里的配置，可以在这里进行统一的设置
                String cacheControl = request.cacheControl().toString();
                return originalResponse.newBuilder()
                        .header("Cache-Control", cacheControl)
                        .removeHeader("Pragma")
                        .build();
            } else {
                return originalResponse.newBuilder()
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + CACHE_STALE_SEC)
                        .removeHeader("Pragma")
                        .build();
            }
        }
    };
//    private static final Interceptor mLoggingInterceptor = new Interceptor() {
//        @Override
//        public Response intercept(Chain chain) throws IOException {
//            Request request = chain.request();
//            Response response = chain.proceed(request);
//            return response;
//        }
//    };
//
//    /**
//     * 查询缓存的Cache-Control设置，为if-only-cache时只查询缓存而不会请求服务器，max-stale可以配合设置缓存失效时间
//     * max-stale 指示客户机可以接收超出超时期间的响应消息。如果指定max-stale消息的值，那么客户机可接收超出超时期指定值之内的响应消息。
//     */
//    private static final String CACHE_CONTROL_CACHE = "only-if-cached, max-stale=" + CACHE_STALE_SEC;
//
//    /**
//     * 查询网络的Cache-Control设置，头部Cache-Control设为max-age=0
//     * (假如请求了服务器并在a时刻返回响应结果，则在max-age规定的秒数内，浏览器将不会发送对应的请求到服务器，数据由缓存直接返回)时则不会使用缓存而请求服务器
//     */
//    private static final String CACHE_CONTROL_AGE = "max-age=0";
//    static final String AVOID_HTTP403_FORBIDDEN = "User-Agent: Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11";
//
//    public static String getCacheControl() {
//        return NetUtil.isNetworkAvailable() ? CACHE_CONTROL_AGE : CACHE_CONTROL_CACHE;
//    }
}
