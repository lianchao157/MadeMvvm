package com.e.mademvvm.mvvmnews.ui.videolist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.e.mademvvm.R;


/****
 * 2022.11.18
 * 视频列表展示
 * 目的 上拉刷新加载
 */

public class VideoListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_list);

    }
}