package com.e.mademvvm.mvvmnews.baseurltihuan;

import com.e.mademvvm.mvvmnews.BaseResponse;
import com.e.mademvvm.mvvmnews.baseurltihuan.bean.BaseHttpEntity;
import com.e.mademvvm.mvvmnews.baseurltihuan.bean.LoginForAccessTokenEntity;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.FormBody;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public
interface RemoteService {

    /**
     * 登陆请求token
     */


//    测试
    @Headers("urlname:common_base_url_header")
    @POST("地址1")
    Observable<Response<BaseHttpEntity>>
    loginForToken(@Body FormBody formbody);

    //    测试测试
    @Headers("urlname:test2")
    @GET("地址2")
    Observable<BaseResponse> getJData(@QueryMap Map<String, String> map);

}
