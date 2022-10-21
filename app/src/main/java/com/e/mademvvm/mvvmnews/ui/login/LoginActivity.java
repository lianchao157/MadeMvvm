package com.e.mademvvm.mvvmnews.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.e.mademvvm.R;
import com.e.mademvvm.config.HttpConfig;
import com.e.mademvvm.databinding.ActivityLoginBinding;
import com.e.mademvvm.mvvmnews.MainActivity;
import com.e.mademvvm.mvvmnews.bean.BaseReqData;
import com.e.mademvvm.mvvmnews.bean.loginbean.UserBean;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
//import androidx.lifecycle.ViewModelProvider;

//import com.e.createmcvp.R;
//import com.e.createmcvp.config.HttpConfig;
//import com.e.createmcvp.databinding.ActivityLoginBinding;
//import com.e.createmcvp.mvvmnews.MainActivity;
//import com.e.createmcvp.mvvmnews.bean.BaseReqData;
//import com.e.createmcvp.mvvmnews.bean.loginbean.UserBean;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

/***
 * 主页登陆可以使用
 */
public class LoginActivity extends AppCompatActivity {
    // 声明对象
    private LoginViewModel loginViewModel;
    ActivityLoginBinding activityLoginActiviityBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        activityLoginActiviityBinding
                = ActivityLoginBinding.inflate(LayoutInflater.from(this));
        setContentView(activityLoginActiviityBinding.getRoot());

        //登录点击事件
        activityLoginActiviityBinding.btnLongin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginViewModel.login(getUserName(), getUserPass());
            }
        });

        loginViewModel.loginLiveData.observe(this, new Observer<BaseReqData<UserBean>>() {
            @Override
            public void onChanged(BaseReqData<UserBean> userBeanBaseReqData) {
                if (userBeanBaseReqData.getStatue().equals(HttpConfig.REQUEST_OK)) {
                    showToast(userBeanBaseReqData.getMsg());
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    showToast(userBeanBaseReqData.getMsg());
                }
            }
        });
    }

    /**
     * toast 提示
     *
     * @param message 提示内容
     */
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    /**
     * 获取输入框的用户名
     *
     * @return
     */
    private String getUserName() {
        return activityLoginActiviityBinding.edAccunt.getText().toString().trim();
    }

    /**
     * 获取输入框的密码
     *
     * @return
     */
    private String getUserPass() {
        return activityLoginActiviityBinding.edPass.getText().toString().trim();
    }


    public class MyViewModel extends ViewModel {
        public int count;
    }
}