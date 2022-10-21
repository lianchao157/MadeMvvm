package com.e.mademvvm.mvvmnews.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.e.mademvvm.R;
import com.e.mademvvm.mvvmnews.bean.NewBean;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public  class HomeFragmet extends Fragment {
    private HomeViewModel homeViewModel;

    private RecyclerView recyclerView;

    private RecyclerView.LayoutManager layoutManager;

    private View root;

    private String appKey = "04ea095cbea56775e2d1669713f34cc2";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        homeViewModel = new ViewModelProvider(this, new HomeViewModelFactory(appKey)).get(HomeViewModel.class);
        root = inflater.inflate(R.layout.fragment_home, container, false);
        initView();

        homeViewModel.getNews("top");
        homeViewModel.newsBean.observe(getActivity(),new Observer<NewBean>() {
            @Override
            public void onChanged(NewBean newBean) {
                if (newBean != null) {
                    if (newBean.getError_code() == 0) {
                        NewsAdapter newsAdapter = new NewsAdapter(newBean.getResult().getData(), getActivity());
                        recyclerView.setAdapter(newsAdapter);
                    }
                }
            }
        });


        return root;
    }

    private void initView() {
        recyclerView = root.findViewById(R.id.recycleView);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
    }
}
