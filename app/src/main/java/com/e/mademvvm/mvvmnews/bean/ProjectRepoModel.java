package com.e.mademvvm.mvvmnews.bean;

import com.e.mademvvm.mvvmnews.bean.regin.ReginUser;

import java.util.List;

/***
 * 带返回值的
 */
public  class ProjectRepoModel {

    private List<ReginUser> mList;
    private Throwable mThrowable;
    public ProjectRepoModel (List<ReginUser> mList) {
        mList= mList;
    }

    public ProjectRepoModel (Throwable throwable) {
        mThrowable = throwable;
    }

    public List<ReginUser> getList() {
        return mList;
    }

    public Throwable getThrowable() {
        return mThrowable;
    }

}
