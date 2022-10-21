package com.e.mademvvm.mvvmnews.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

//import com.e.createmcvp.R;
//import com.e.createmcvp.databinding.ItemNewsBinding;
//import com.e.createmcvp.mvvmnews.bean.NewBean;

import com.e.mademvvm.R;
import com.e.mademvvm.databinding.ItemNewsBinding;
import com.e.mademvvm.mvvmnews.bean.NewBean;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public  class NewsAdapter extends   RecyclerView.Adapter<RecyclerView.ViewHolder> {


private List<NewBean.ResultBean.DataBean> dataBeans;

private Context mContext;

public NewsAdapter(List<NewBean.ResultBean.DataBean> dataBeans, Context mContext) {
        this.dataBeans = dataBeans;
        this.mContext = mContext;
        }

@NonNull
@Override
public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ItemNewsBinding itemNewsBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
        R.layout.item_news, parent, false);
        ViewHolderItemNews viewHolderItemNews = new ViewHolderItemNews(itemNewsBinding);
        return viewHolderItemNews;
        }
// 这里面 ItemNewsBinding  这个是实体类
@Override
public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ItemNewsBinding itemNewsBinding = ((ViewHolderItemNews) holder).getViewDataBinding();
        itemNewsBinding.setNews(dataBeans.get(position));
        itemNewsBinding.setItemClick(new ClickBinding());
        itemNewsBinding.executePendingBindings();
        }

@Override
public int getItemCount() {
        return dataBeans.size();
        }


private class ViewHolderItemNews extends RecyclerView.ViewHolder {

    private ItemNewsBinding viewDataBinding;

    public ItemNewsBinding getViewDataBinding() {
        return viewDataBinding;
    }

    public void setViewDataBinding(ItemNewsBinding viewDataBinding) {
        this.viewDataBinding = viewDataBinding;
    }

    public ViewHolderItemNews(ItemNewsBinding inflate) {
        super(inflate.getRoot());
        this.viewDataBinding = inflate;
    }
}
}
