package com.e.mademvvm.mvvmnews.ui.videolist;

//import com.e.createmcvp.mvvmnews.bean.BaseReqData;
//import com.e.createmcvp.mvvmnews.bean.loginbean.Reqbean;
//import com.e.createmcvp.mvvmnews.bean.loginbean.UserBean;
//import com.e.createmcvp.repository.LoginRepository;

import com.e.mademvvm.mvvmnews.bean.loginbean.Reqbean;
import com.e.mademvvm.mvvmnews.bean.loginbean.UserBean;
import com.e.mademvvm.mvvmnews.bean.regin.ReginUser;
import com.e.mademvvm.mvvmnews.bean.regin.User;
import com.e.mademvvm.repository.LoginRepository;
import com.e.mademvvm.repository.ReginUserRepository;

import java.util.List;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

/***
 * 登陆的view modlel
 */
public class VideoListModel extends ViewModel {

    public List<Reqbean> getmList() {
        return mList;
    }

    public void setmList(List<Reqbean> mList) {
        this.mList = mList;
    }

    public Throwable getmThrowable() {
        return mThrowable;
    }

    public void setmThrowable(Throwable mThrowable) {
        this.mThrowable = mThrowable;
    }

    public MutableLiveData<UserBean> getReqbeanMutableLiveData() {
        return reqbeanMutableLiveData;
    }

    public void setReqbeanMutableLiveData(MutableLiveData<UserBean> reqbeanMutableLiveData) {
        this.reqbeanMutableLiveData = reqbeanMutableLiveData;
    }

    public LiveData<Reqbean> getLoginLiveData() {
        return loginLiveData;
    }

    public void setLoginLiveData(LiveData<Reqbean> loginLiveData) {
        this.loginLiveData = loginLiveData;
    }

    private List<Reqbean> mList;
    private Throwable mThrowable;

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


    /***
     * 注册方法
     * @param userid
     * @param userpassword
     */
    public void regin(String userid, String userpassword) {
        {
            User reqbean = new User(userid, userpassword,null);

            reginreqbeanMutableLiveData1.setValue(reqbean);
        }

    }

    private MutableLiveData<User> reginreqbeanMutableLiveData1 = new MutableLiveData<>();
    public LiveData<ReginUser> reginLiveData = Transformations.switchMap(reginreqbeanMutableLiveData1,
    new Function<User, LiveData<ReginUser>>() {
        @Override
        public LiveData<ReginUser> apply(User input) {
            String  usernno=input.getUsernaem();
            String   ps=input.getPs();
            return  ReginUserRepository.reginuser(usernno,ps,"input.getPs()");
        }

    });

}
