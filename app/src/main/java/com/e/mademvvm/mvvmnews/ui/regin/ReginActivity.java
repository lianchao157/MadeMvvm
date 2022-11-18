package com.e.mademvvm.mvvmnews.ui.regin;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.e.mademvvm.R;
import com.e.mademvvm.databinding.ActivityLoginBinding;
import com.e.mademvvm.mvvmnews.ui.login.LoginActivity;
import com.e.mademvvm.mvvmnews.ui.login.LoginViewModel;
import com.e.mademvvm.mvvmnews.ui.view.TitlebarView;
import com.e.mademvvm.databinding.ActivityReginBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

/***
 * 注册
 */
public class ReginActivity extends AppCompatActivity {
    private ReginViewModel reginViewModel;
    ActivityReginBinding activityReginActiviityBinding;
    private EditText edsuper;//  接受信息
    private Button btnupdata;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityReginActiviityBinding
                = ActivityReginBinding.inflate(LayoutInflater.from(this));
        mContext = ReginActivity.this;
        activityReginActiviityBinding.titletitlebar.setTitle("登陆");
        activityReginActiviityBinding.titletitlebar.setTitleSize(20);
        setContentView(activityReginActiviityBinding.getRoot());

        reginViewModel = new ViewModelProvider(this).get(ReginViewModel.class);
        activityReginActiviityBinding.titletitlebar.setOnViewClick(new TitlebarView.onViewClick() {
            @Override
            public void leftClick() {
                Toast.makeText(ReginActivity.this, "左边", Toast.LENGTH_SHORT).show();
                ReginActivity.this.finish();
            }

            @Override
            public void rightClick() {
                Toast.makeText(ReginActivity.this, "右边", Toast.LENGTH_SHORT).show();
            }
        });

        String result = activityReginActiviityBinding.edsuper.getText().toString().trim();
        System.out.println("结果：：：：：：：" + result);
        initView();
    }

    private void initView() {
        activityReginActiviityBinding.btnupdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usern = activityReginActiviityBinding.edsuper.getText().toString().trim();
                String password = activityReginActiviityBinding.edsuper.getText().toString().trim();
                System.out.println("内容" + usern);
                System.out.println("内容" + password);
                reginViewModel.regin(usern, password);
            }
        });
    }
}