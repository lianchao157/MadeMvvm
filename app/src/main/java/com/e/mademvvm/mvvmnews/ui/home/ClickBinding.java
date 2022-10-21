package com.e.mademvvm.mvvmnews.ui.home;

import android.content.Intent;
import android.view.View;

import com.e.mademvvm.mvvmnews.bean.NewBean;


/***
 * 携带参数点击跳转
 */
public class ClickBinding {

    public void itemClick(NewBean.ResultBean.DataBean dataBean, View view){
        Intent intent = new Intent(view.getContext(), NewsDetailActivity.class);
        intent.putExtra("newsurl", dataBean.getUrl());
        view.getContext().startActivity(intent);
    }
}
