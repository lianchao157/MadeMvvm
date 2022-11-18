package com.e.mademvvm.mvvmnews.baseurltihuan;

import com.e.mademvvm.config.Constants;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.List;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
public  class MoreBaseUrlInterceptor implements Interceptor  {
    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        //获取原始的originalRequest
        Request originalRequest = chain.request();
        //获取老的url
        HttpUrl oldUrl = originalRequest.url();
        //获取originalRequest的创建者builder
        Request.Builder builder = originalRequest.newBuilder();
        //获取头信息的集合如：manage,mdffx
        List<String> urlnameList = originalRequest.headers("urlname");
        if (urlnameList != null && urlnameList.size() > 0) {
            //删除原有配置中的值,就是namesAndValues集合里的值
            builder.removeHeader("urlname");
            //获取头信息中配置的value,如：manage或者mdffx
            String urlname = urlnameList.get(0);
            HttpUrl baseURL = null;
            //根据头信息中配置的value,来匹配新的base_url地址
            // FIXME: 2019/5/30 此处可以根据实际需求 进行 baseURL的切换
            if ("common_base_url_header".equals(urlname)) {
                baseURL = HttpUrl.parse("");
            } else if ("old_php_base_url_header".equals(urlname)) {
                //baseURL = HttpUrl.parse(App.getInstance().setBaseUrlOldPhp());
            } else if ("java".equals(urlname)) {
                baseURL = HttpUrl.parse("");
            }


            //重建新的HttpUrl，需要重新设置的url部分
            HttpUrl newHttpUrl = oldUrl.newBuilder()
                    .scheme(baseURL.scheme())//http协议如：http或者https
                    .host(baseURL.host())//主机地址
                    .port(baseURL.port())//端口
                    .build();
            String header = originalRequest.header("NoToken");
            if (header == null) {
                builder.addHeader("Cookie", "UserUtils.getCokeValue()")
                        .addHeader("Content-Type", "application/x-www-form-urlencoded")
                        .addHeader("X-Requested-With", "XMLHttpRequest");
            }

            //获取处理后的新newRequest
            Request newRequest = builder.url(newHttpUrl).build();
            return chain.proceed(newRequest);
        } else {
            return chain.proceed(originalRequest);
        }

    }
}
