package com.e.mademvvm.mvvmnews.ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.e.mademvvm.R;
import com.e.mademvvm.databinding.ActivityLoginBinding;
import com.e.mademvvm.mvvmnews.MainActivity;
import com.e.mademvvm.mvvmnews.bean.loginbean.Reqbean;
import com.e.mademvvm.mvvmnews.ui.regin.ReginActivity;
import com.e.mademvvm.utils.SharePreUril;

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
    private SharePreUril sharePreUril;

    // 声明对象
    private LoginViewModel loginViewModel;
    ActivityLoginBinding activityLoginActiviityBinding;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        context=LoginActivity.this;
//        sp = getSharedPreferences("sp_demo", Context.MODE_PRIVATE);
        context = LoginActivity.this;
        sharePreUril = new SharePreUril(context);
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        activityLoginActiviityBinding
                = ActivityLoginBinding.inflate(LayoutInflater.from(this));
        setContentView(activityLoginActiviityBinding.getRoot());

        //登录点击事件
        activityLoginActiviityBinding.btnLongin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getUserName().equals("")) {
                    showToast("账号不能为空");
                } else if (getUserPass().equals("")) {
                    showToast("不能为空");
                } else {
                    loginViewModel.login(getUserName(), getUserPass());
//                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                    startActivity(intent);
                }

            }
        });
        activityLoginActiviityBinding.botBarShopcar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("我是购物车");

            }
        });
        activityLoginActiviityBinding.wxlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                 这里要做微信的授权的登陆
            }
        });

        loginViewModel.loginLiveData.observe(this, new Observer<Reqbean>() {
            @Override
            public void onChanged(Reqbean reqbean) {
                System.out.println("成功!!!getCode!!!：" + reqbean.getCode());
                System.out.println("成功!!!!!!：" + reqbean.getCode());
                if (0==(reqbean.getCode())) {
                    if (null!=reqbean.getData()||!reqbean.getData().getToken().equals("")) {
                        sharePreUril.putRefreshToken(reqbean.getData().getToken());
                        showToast("成功");
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);

                    }

                } else {
                    showToast("失败" + reqbean.getMsg());
                }
            }


        });
//        注册操作
        activityLoginActiviityBinding.btnRegin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ReginActivity.class);
                startActivity(intent);
            }
        });

//        loginViewModel.reginLiveData.observe(this, new Observer<UserBean>() {
//            @Override
//            public void onChanged(UserBean userBean) {
////                这里应该用返回码进行判断
//                if(null==userBean){
//                    showToast("注册失败了");
//                }
//            }
//        });
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