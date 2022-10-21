package com.e.mademvvm.mvvmnews.ui.home;
import android.util.Log;
import com.e.mademvvm.mvvmnews.bean.NewBean;
import com.e.mademvvm.mvvmnews.http.apiservice.ApiServices;
import com.e.mademvvm.mvvmnews.http.apiservice.BaseSubscriber;
import com.e.mademvvm.mvvmnews.http.apiservice.RetrofitServiceBuilder;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class NewRepository {
    private static final String TAG = "NewRepository";

    public LiveData<NewBean> getNews(String type, String appkey) {
        final MutableLiveData<NewBean> mutableLiveData = new MutableLiveData<>();
//        网络请求
        ApiServices apiServices = RetrofitServiceBuilder.createService(ApiServices.class);
        if (apiServices != null) {
            apiServices.getNews(type, appkey)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new BaseSubscriber<NewBean>() {
                        @Override
                        public void onNext(NewBean newBean) {
                            Log.d(TAG, "onNext: 在这里");
                            mutableLiveData.setValue(newBean);
                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.d(TAG, "onError: " + e.toString());
                        }
                    });
        }

        return mutableLiveData;
    }
}
