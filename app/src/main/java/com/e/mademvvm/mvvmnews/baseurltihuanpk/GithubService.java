package com.e.mademvvm.mvvmnews.baseurltihuanpk;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

/***
 * 替换
 * //    原文链接：https://blog.csdn.net/u013762572/article/details/88910098
 */
public
interface GithubService {

    // 这是请求github的地址
    @GET("users/{user}/repos")
    Call<List<String>> listRepos(@Path("user") String user);

//    // 这是请求gank.io的地址
//    @GET("history/content/{month}/{day}")
//    Call<GankEntity> getGankEntity(@Header(HXConstant.NEW_URL_KEY) String url,
//                                   @Path("month") String month,
//                                   @Path("day") String day);

}
