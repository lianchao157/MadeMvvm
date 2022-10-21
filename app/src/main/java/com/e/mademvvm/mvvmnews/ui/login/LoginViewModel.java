package com.e.mademvvm.mvvmnews.ui.login;

//import com.e.createmcvp.mvvmnews.bean.BaseReqData;
//import com.e.createmcvp.mvvmnews.bean.loginbean.Reqbean;
//import com.e.createmcvp.mvvmnews.bean.loginbean.UserBean;
//import com.e.createmcvp.repository.LoginRepository;
import com.e.mademvvm.mvvmnews.bean.BaseReqData;
import com.e.mademvvm.mvvmnews.bean.loginbean.Reqbean;
import com.e.mademvvm.mvvmnews.bean.loginbean.UserBean;
import com.e.mademvvm.repository.LoginRepository;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

/***
 * 登陆的view modlel
 */
public class LoginViewModel extends ViewModel {

    private MutableLiveData<Reqbean> reqbeanMutableLiveData = new MutableLiveData<>();
    public LiveData<BaseReqData<UserBean>> loginLiveData = Transformations.switchMap(reqbeanMutableLiveData, new Function<Reqbean, LiveData<BaseReqData<UserBean>>>() {
        @Override
        public LiveData<BaseReqData<UserBean>> apply(Reqbean input) {
            return LoginRepository.login(input.getUserName(), input.getUserPass());
        }
    });

    /***
     * 登陆方法
     */
    public void login(String userName, String userPass)

    {
        Reqbean reqbean = new Reqbean(userName, userPass);
        reqbeanMutableLiveData.setValue(reqbean);
    }
}
