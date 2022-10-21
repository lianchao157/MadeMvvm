package com.e.mademvvm.mvvmnews.http.apiservice;


import com.e.mademvvm.mvvmnews.bean.NewBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

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
}
