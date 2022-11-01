package com.e.mademvvm.mvvmnews.ui.aboutme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.e.mademvvm.R;
import com.e.mademvvm.databinding.ActivityLoginBinding;
import com.e.mademvvm.mvvmnews.ui.login.LoginViewModel;

/***
 *运用 mvvm 写代码测试
 */
public class AboutActivity extends AppCompatActivity {
    private LoginViewModel loginViewModel;
    ActivityLoginBinding activityLoginActiviityBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }
}