package com.guet.common.utils;

import android.app.Activity;

import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;

/**
 * 此类用于操作 TitleBar 的工具类
 *
 * @author dhxstart
 * @date 2022/1/9 16:17
 */
public class TitleBarUtils {

    /**
     * 此方法用于点击back按钮后，销毁当前activity
     *
     * @param titleBar 标题栏
     * @param activity 当前activity组件
     */
    public static void clickLeftBack(TitleBar titleBar, final Activity activity) {
        titleBar.setOnTitleBarListener(new OnTitleBarListener() {
            @Override
            public void onLeftClick(TitleBar titleBar) {
                activity.finish();
            }
        });
    }
}
