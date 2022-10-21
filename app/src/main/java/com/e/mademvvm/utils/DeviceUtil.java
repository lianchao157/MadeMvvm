package com.e.mademvvm.utils;

import android.content.Context;
import android.content.res.Configuration;

public
class DeviceUtil {
    /**
     * 检查当前系统是否已开启暗黑模式
     *
     * @param context 上下文
     * @return
     */
    public static boolean getDarkModeStatus(Context context) {
        int mode = context.getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        return mode == Configuration.UI_MODE_NIGHT_YES;
    }

}
