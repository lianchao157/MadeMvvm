package com.e.mademvvm.mvvmnews.ui.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.e.mademvvm.BaseApplication;
import com.squareup.picasso.Picasso;

import androidx.annotation.Nullable;


/***
 * 自定义组件
 */
@SuppressLint("AppCompatCustomView")
public   class DataImageView extends ImageView {
    public DataImageView(Context context) {
        super(context);
    }

    public DataImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DataImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public DataImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
    // 设置imageview 的url、
    public  static void setImageUrl(ImageView  imageView ,String url){
        Picasso.with(BaseApplication.getContext()).load(url)
                .into(imageView);

    }
}
