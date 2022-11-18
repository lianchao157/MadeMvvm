package com.e.mademvvm.mvvmnews.baseurltihuanpk;

import android.text.TextUtils;
import android.util.Log;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field;

import okhttp3.Call;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public
class HxCallFactory implements okhttp3.Call.Factory{
    //真实请求还是OkHttpClient，只是在请求之前，换掉URL即可

    private okhttp3.Call.Factory realCall = new OkHttpClient();
    private String replaceURL;
    public HxCallFactory(String replaceURL) {
        this.replaceURL = replaceURL;
    }
    @Override
    public Call newCall(Request request) {
        Headers headers = request.headers();
        int headersSize = headers.size();

        if (headersSize > 0) {
            //获取我所填的新的URL地址
            String newUrl = headers.get(HXConstant.NEW_URL_KEY);

            if (!TextUtils.isEmpty(newUrl)) { //获取新的url
                //旧的URL替换掉新的URL
                String newUrlStr = request.url().toString().replace(replaceURL, newUrl);
                HttpUrl newHttpUrl = HttpUrl.get(newUrlStr);

                //将header无用数据清除
                Headers createNewHeaders = createNewHeader(request.headers());

                Field urlField;
                Field headerField;
                try {
                    urlField = request.getClass().getDeclaredField("url");
                    urlField.setAccessible(true);
                    urlField.set(request, newHttpUrl);

                    headerField = request.getClass().getDeclaredField("headers");
                    headerField.setAccessible(true);
                    headerField.set(request,createNewHeaders);

                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                }

                Log.d("URL2", "newCall: " + request.url());
            }
        }

        return realCall.newCall(request);
    }

    //刚才自己的对应的URL地址清除掉
    private Headers createNewHeader(Headers headers) {
        if (null == headers) return null;
        int headerSize = headers.size();

        okhttp3.Headers.Builder builder = new okhttp3.Headers.Builder();
        for (int i = 0; i < headerSize; i++) {
            if (HXConstant.NEW_URL_KEY.equals(headers.name(i))) continue;
            builder.add(headers.name(i), headers.value(i));
        }
        return builder.build();
    }
}
