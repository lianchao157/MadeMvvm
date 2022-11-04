package com.e.mademvvm.mvvmnews.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.e.mademvvm.R;
import com.e.mademvvm.mvvmnews.ui.view.TitlebarView;

/***
 * 注册
 */
public class ReginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regin);
        TitlebarView titlebarView = (TitlebarView) findViewById(R.id.title);
        titlebarView.setTitleSize(20);
        titlebarView.setTitle("标题栏");
        titlebarView.setOnViewClick(new TitlebarView.onViewClick() {
            @Override
            public void leftClick() {
                Toast.makeText(ReginActivity.this, "左边", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void rightClick() {
                Toast.makeText(ReginActivity.this, "右边", Toast.LENGTH_SHORT).show();
            }
        });
    }
}