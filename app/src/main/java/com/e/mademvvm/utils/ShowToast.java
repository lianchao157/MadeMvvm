package com.e.mademvvm.utils;

import android.content.Context;
import android.widget.Toast;
//2022.11.18.10
public class ShowToast {
    public static void show(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
