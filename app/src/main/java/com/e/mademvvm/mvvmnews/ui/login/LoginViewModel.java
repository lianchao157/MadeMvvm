package com.e.mademvvm.mvvmnews.ui.login;

import com.e.mademvvm.mvvmnews.bean.loginbean.Reqbean;
import com.e.mademvvm.mvvmnews.bean.loginbean.UserBean;
import com.e.mademvvm.repository.LoginRepository;

import java.util.List;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

/***
 * 登陆的view modlel
 */
public class LoginViewModel extends ViewModel {

    private MutableLiveData<UserBean> reqbeanMutableLiveData = new MutableLiveData<>();
    public LiveData<Reqbean> loginLiveData = Transformations.switchMap(reqbeanMutableLiveData,
            new Function<UserBean, LiveData<Reqbean>>() {


                @Override
                public LiveData<Reqbean> apply(UserBean input) {
                    return LoginRepository.login(input.getUsername(), input.getUsertel());
                }
            });

    /***
     * 登陆方法
     */
    public void login(String userName, String userPass) {
        UserBean userBean=new UserBean();
        userBean.setUsertel(userPass);
        userBean.setUsername(userName);
        reqbeanMutableLiveData.setValue(userBean);
    }



}
