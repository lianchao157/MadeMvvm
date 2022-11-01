package com.e.mademvvm.mvvmnews.http.apiservice;


import com.e.mademvvm.mvvmnews.BaseResponse;
import com.e.mademvvm.mvvmnews.bean.Bean;
import com.e.mademvvm.mvvmnews.bean.NewBean;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface ApiServices {
    /**
     * 获取新闻数据
     *
     * @param type 类型
     * @param key  appkey
     * @return
     */
    @GET("toutiao/index")
    Observable<NewBean> getNews(@Query("type") String type, @Query("key") String key);



//    多baseurl 测试
    @Headers("urlname:test1")
    @GET("地址1")
    Observable<BaseResponse > getHData(@QueryMap Map<String, String> map);
//    多baseurl 测试
    @Headers("urlname:test2")
    @GET("地址2")
    Observable<BaseResponse> getJData(@QueryMap Map<String, String> map);
}
