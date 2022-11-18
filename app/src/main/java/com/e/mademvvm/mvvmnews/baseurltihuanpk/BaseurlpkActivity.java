package com.e.mademvvm.mvvmnews.baseurltihuanpk;

import androidx.appcompat.app.AppCompatActivity;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.util.Log;

import com.e.mademvvm.R;
import com.e.mademvvm.mvvmnews.bean.NewBean;
import com.e.mademvvm.mvvmnews.http.apiservice.ApiServices;
import com.e.mademvvm.mvvmnews.http.apiservice.BaseSubscriber;
import com.e.mademvvm.mvvmnews.http.apiservice.RetrofitServiceBuilder;

import java.util.List;

/****
 * 目的修改baseurl
 * https://blog.csdn.net/u013762572/article/details/88910098
 */
public class BaseurlpkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baseurlpk);

        loadData();
    }

    private void loadData() {
        GithubService   service= Retrofitmange.retrofit.create((GithubService.class));
        service.listRepos("").enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {

            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {

            }
        });
//        GithubService   service=Retrofitmange.createService(GithubService.class);
//        service.listRepos("张三").enqueue(new Callback<List<String>>() {
//            @Override
//            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
//
//            }
//
//            @Override
//            public void onFailure(Call<List<String>> call, Throwable t) {
//
//            }
//        });


        Call<List<String>> call = service.listRepos("Microhx");

        call.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {}

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}