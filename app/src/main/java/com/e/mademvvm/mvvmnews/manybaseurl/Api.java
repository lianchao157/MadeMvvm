package com.e.mademvvm.mvvmnews.manybaseurl;

/***
 * 网络请求的url
 * ynchronized顾名思义，就是用来进行一些同步工作的，我们常常在多线程的环境中使用到它，实现互斥的效果。
 */
public  interface Api {
    String APP_DEFAULT_DOMAIN = "http://jessyan.me";

    String APP_GITHUB_DOMAIN = "https://api.github.com";
    String APP_GANK_DOMAIN = "http://gank.io";
    String APP_DOUBAN_DOMAIN = "https://api.douban.com";

    String GITHUB_DOMAIN_NAME = "github";
    String GANK_DOMAIN_NAME = "gank";
    String DOUBAN_DOMAIN_NAME = "douban";
}
