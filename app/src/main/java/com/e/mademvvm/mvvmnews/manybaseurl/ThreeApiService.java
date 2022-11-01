package com.e.mademvvm.mvvmnews.manybaseurl;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

import static com.e.mademvvm.mvvmnews.manybaseurl.Api.DOUBAN_DOMAIN_NAME;
import static me.jessyan.retrofiturlmanager.RetrofitUrlManager.DOMAIN_NAME_HEADER;

public
interface ThreeApiService {
    /**
     * 如果不需要多个 BaseUrl, 继续使用初始化时传入 Retrofit 中的默认 BaseUrl, 就不要加上 DOMAIN_NAME_HEADER 这个 Header
     */
    @Headers({DOMAIN_NAME_HEADER + DOUBAN_DOMAIN_NAME})
    /**
     * 可以通过在注解里给全路径达到使用不同的 BaseUrl, 但是这样无法在 App 运行时动态切换 BaseUrl
     */
    @GET("/v2/book/{id}")
    Observable<ResponseBody> getBook(@Path("id") int id);
}
