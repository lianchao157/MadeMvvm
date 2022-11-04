package com.e.mademvvm.mvvmnews.ui.dashboard;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


import com.e.mademvvm.R;
import com.e.mademvvm.mvvmnews.ui.aboutme.AbouteMeFragment;
import com.e.mademvvm.mvvmnews.ui.blank.BlankFragment;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

/***
 * 这里的为androidx 的app  fragilement
 */
public class DashboardFragment  extends Fragment {
    private BlankFragment blank;
    private DashboardViewModel dashboardViewModel;
    private Fragment fragment;//用该变量表示现在展示的是哪一个fragment
    private FragmentManager manager;

//    方法二
    List<Fragment> mFragments = new ArrayList<>();
    private RadioGroup radioGroup;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        dashboardViewModel = ViewModelProviders.of(this).get(DashboardViewModel.class);

        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        radioGroup = (RadioGroup) root.findViewById(R.id.select_button);
        mFragments.add(new BlankFragment());
        mFragments.add(new AbouteMeFragment());
        mFragments.add(new BlankFragment());
        radioGroup.setOnCheckedChangeListener(mCheckChangeListener);
        ((RadioButton) radioGroup.getChildAt(0)).setChecked(true);




        final TextView textView = root.findViewById(R.id.text_dashboard);
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
    private RadioGroup.OnCheckedChangeListener mCheckChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            View child = radioGroup.findViewById(i);//这个i是选中的那个radioButton的id
            int index = radioGroup.indexOfChild(child);//根据radioButton去比较radioGroup拿到位置
            Fragment fragment = mFragments.get(index);
            addHideShowFragment(fragment);
        }
    };

    //看公司需求，这个是替换，就跟刷新一样
    private void replaceFragment(Fragment fragment) {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.replace_2, fragment)
                .commit();
    }


    // replace 操作和 add remove  没什么用
    private void addRemoveFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.replace_2, fragment);
        if (mCurrentFragment != null) {
            fragmentTransaction.remove(mCurrentFragment);
        }
        fragmentTransaction.commit();
        mCurrentFragment = fragment;
    }

    // hide  和  show 操作，不会对生命周期方法产生影响,就是你返回之后，还是在相同的地方
    Fragment mCurrentFragment;
    List<Fragment> mHasAddFragments = new ArrayList<Fragment>();

    private void addHideShowFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

        // 如果fragment没有添加过，就添加，
        // 如果fragment添加过，就显示
        // 如果原来的fragment存在，就隐藏
        if (!mHasAddFragments.contains(fragment)) {
            fragmentTransaction.add(R.id.replace_2, fragment);
            mHasAddFragments.add(fragment);
        } else {
            fragmentTransaction.show(fragment);
        }
        if (mCurrentFragment != null) {
            fragmentTransaction.hide(mCurrentFragment);
        }
        mCurrentFragment = fragment;
        fragmentTransaction.commit();

    }

}
