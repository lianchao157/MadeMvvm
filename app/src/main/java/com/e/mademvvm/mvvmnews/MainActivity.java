package com.e.mademvvm.mvvmnews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.View;

import com.e.mademvvm.R;
import com.e.mademvvm.mvvmnews.ui.dashboard.DashboardFragment;
import com.e.mademvvm.utils.DeviceUtil;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/***
 * 主页面的
 */
public class MainActivity extends AppCompatActivity {
    private FloatingActionButton floatingActionButton;
    private FloatingActionButton btnChangeTheme;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        getSupportFragmentManager().beginTransaction().replace(R.id.rest,new DashboardFragment()).commit();
        BottomNavigationView   navigationView=findViewById(R.id.nav_view);
        AppBarConfiguration appBarConfiguration =new AppBarConfiguration.
                Builder(R.id.navigation_dashboard).build();
        navigationView.setItemIconTintList(null);
        navigationView.setItemRippleColor(null);
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        //默认动画
        navigationView.setLabelVisibilityMode(0);
        //默认清除动画（显示文字）
        navigationView.setLabelVisibilityMode(1);
        btnChangeTheme = findViewById(R.id.btn_change_theme);
        btnChangeTheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (DeviceUtil.getDarkModeStatus(MainActivity.this)) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }

//                AppCompatDelegate有四种模式可以设置:
//
//MODE_NIGHT_YES:直接指定夜间模式
//
//MODE_NIGHT_NO：直接指定日间模式
//
//MODE_NIGHT_FOLLOW_SYSTEM:根据系统设置决定是否设置夜间模式
//
//MODE_NIGHT_AUTO:根据当前时间自动切换模式
            }
        });
    }
}