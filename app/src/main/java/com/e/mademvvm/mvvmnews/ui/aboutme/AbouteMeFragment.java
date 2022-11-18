package com.e.mademvvm.mvvmnews.ui.aboutme;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.e.mademvvm.R;
import com.e.mademvvm.config.HttpConfig;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public
class AbouteMeFragment extends Fragment {
private WebView webview;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_selftme, null);
        webview=view.findViewById(R.id.mywebview);
        webview.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY);

        webview.setHorizontalScrollBarEnabled(false);

//加载网络页面
        HttpConfig  httpConfig=new HttpConfig();
//        webview.loadUrl(httpConfig.BASE_APIBYmySelef+"/aboutme.html");

        webview.loadUrl( "http://192.168.43.33:8087/aboutme.html");
//加载本地html

//        HttpConfig.loadUrl("file:///android_asset/demo.html");
//
////加载html源码
//
//        HttpConfig.loadDataWithBaseURL("","html源码","text/html","utf-8","");

//        WebView网页现实的相关设置要通过

//        WebSettings设置，如下：

        WebSettings settings = webview.getSettings();

//支持JavaScript

        settings.setJavaScriptEnabled(true);

//支持网页缩放

        settings.setSupportZoom(true);

        settings

                .setBuiltInZoomControls(true);

//设置网页缓存

        settings.setAppCacheEnabled(true);// 开启缓存

        settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);// 缓存优先模式

        settings.setAppCacheMaxSize(8 * 1024 * 1024);// 设置最大缓存为8M

//支持多窗口

        settings.setSupportMultipleWindows(true);
        return view;
    }

}
