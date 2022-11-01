package com.e.mademvvm;

import android.app.Application;
import android.content.Context;

import me.jessyan.retrofiturlmanager.RetrofitUrlManager;

import static com.e.mademvvm.mvvmnews.manybaseurl.Api.APP_DOUBAN_DOMAIN;
import static com.e.mademvvm.mvvmnews.manybaseurl.Api.APP_GANK_DOMAIN;
import static com.e.mademvvm.mvvmnews.manybaseurl.Api.APP_GITHUB_DOMAIN;
import static com.e.mademvvm.mvvmnews.manybaseurl.Api.DOUBAN_DOMAIN_NAME;
import static com.e.mademvvm.mvvmnews.manybaseurl.Api.GANK_DOMAIN_NAME;
import static com.e.mademvvm.mvvmnews.manybaseurl.Api.GITHUB_DOMAIN_NAME;


/**
 * TODO tip 1：需要为项目准备一个 Application 来继承 BaseApplication，
 * 以便在 Activity/Fragment 中享用 Application 级作用域的 event-ViewModel
 * <p>
 * event-ViewModel 的职责仅限于在 "跨页面通信" 的场景下，承担 "唯一可信源"，
 * 所有跨页面的 "状态同步请求" 都交由该可信源在内部决策和处理，并统一分发给所有订阅者页面。
 * <p>
 * 如果这样说还不理解的话，详见《LiveData 鲜为人知的 身世背景 和 独特使命》中结合实际场合 对"唯一可信源"本质的解析。
 * https://xiaozhuanlan.com/topic/0168753249
 * <p>
 * Create by KunMinX at 19/10/29
 */
public  class BaseApplication extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
//        Utils.init(this);
//        PlayerManager.getInstance().init(this);

        RetrofitUrlManager.getInstance().setDebug(true);
        //将每个 BaseUrl 进行初始化,运行时可以随时改变 DOMAIN_NAME 对应的值,从而达到切换 BaseUrl 的效果
        RetrofitUrlManager.getInstance().putDomain(GITHUB_DOMAIN_NAME, APP_GITHUB_DOMAIN);
        RetrofitUrlManager.getInstance().putDomain(GANK_DOMAIN_NAME, APP_GANK_DOMAIN);
        RetrofitUrlManager.getInstance().putDomain(DOUBAN_DOMAIN_NAME, APP_DOUBAN_DOMAIN);
    }

    public static Context getContext() {
        return context;
    }
}
