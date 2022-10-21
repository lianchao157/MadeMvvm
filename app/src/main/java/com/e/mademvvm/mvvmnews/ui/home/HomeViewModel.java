package com.e.mademvvm.mvvmnews.ui.home;


import com.e.mademvvm.mvvmnews.bean.NewBean;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

/***
 * homeview  moudel 类
 */
public
class HomeViewModel extends ViewModel {
    private String appKey;

    public HomeViewModel(String appKey) {
        this.appKey = appKey;
    }

    private MutableLiveData<String> newsType = new MutableLiveData<>();

    public LiveData<NewBean> newsBean = Transformations.switchMap(newsType, new Function<String, LiveData<NewBean>>() {
        @Override
        public LiveData<NewBean> apply(String input) {
            return new NewRepository().getNews(input, appKey);
        }
    });

    public void getNews(String type) {
        newsType.setValue(type);
    }


}