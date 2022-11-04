package com.e.mademvvm.mvvmnews.ui.setting;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SettingViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private MutableLiveData<String> webstr;

    public SettingViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("姓名：黄林晴\n CSDN:https://huanglinqing.blog.csdn.net/");
        webstr = new MutableLiveData<>();
        webstr.setValue("姓名：黄林晴\n CSDN:https://huanglinqing.blog.csdn.net/");
    }

    public LiveData<String> getText() {
        return mText;
    }


    public LiveData<String> getVeburl() {
        return webstr;
    }
}
