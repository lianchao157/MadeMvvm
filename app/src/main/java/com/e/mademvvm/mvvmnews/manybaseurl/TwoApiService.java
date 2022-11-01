package com.e.mademvvm.mvvmnews.manybaseurl;

import io.reactivex.Observable;
import me.jessyan.retrofiturlmanager.RetrofitUrlManager;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

import static com.e.mademvvm.mvvmnews.manybaseurl.Api.GANK_DOMAIN_NAME;
import static me.jessyan.retrofiturlmanager.RetrofitUrlManager.DOMAIN_NAME_HEADER;
public
interface TwoApiService {
    /**
     * 如果不需要多个 BaseUrl, 继续使用初始化时传入 Retrofit 中的默认 BaseUrl, 就不要加上 DOMAIN_NAME_HEADER 这个 Header
     */
    @Headers({DOMAIN_NAME_HEADER + GANK_DOMAIN_NAME})
    /**
     * 在 Url 的尾部加上 {@link RetrofitUrlManager#IDENTIFICATION_PATH_SIZE} + PathSize, 表示此 Url 使用超级模式
     * 超级模式是什么? 请看 {@link RetrofitUrlManager} 的类注释
     * {@link RetrofitUrlManager#IDENTIFICATION_PATH_SIZE} + 2 表示此 Url 中需要被替换的 BaseUrl 为 '域名/api/data', 它的 PathSize 等于 2
     */
    @GET("/api/data/Android/{size}/{page}" + RetrofitUrlManager.IDENTIFICATION_PATH_SIZE + 2)
    Observable<ResponseBody> getData(@Path("size") int size, @Path("page") int page);
}
