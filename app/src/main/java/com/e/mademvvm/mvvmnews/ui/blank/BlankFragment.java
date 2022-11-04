package com.e.mademvvm.mvvmnews.ui.blank;

import android.os.Bundle;
import android.text.style.TtsSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.e.mademvvm.R;
import com.e.mademvvm.mvvmnews.bean.NewBean;
import com.e.mademvvm.mvvmnews.ui.home.HomeViewModel;
import com.e.mademvvm.mvvmnews.ui.home.HomeViewModelFactory;
import com.e.mademvvm.mvvmnews.ui.home.NewsAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public
class BlankFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting, null);
        return view;
    }
}
