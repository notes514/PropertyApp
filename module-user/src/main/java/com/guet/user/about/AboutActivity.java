package com.guet.user.about;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.guet.base.activity.MvvmBaseActivity;
import com.guet.common.router.RouterActivityPath;
import com.guet.common.utils.TitleBarUtils;
import com.guet.user.R;
import com.guet.user.databinding.UserActivityAboutBinding;

@Route(path = RouterActivityPath.User.PAGER_ABOUT)
public class AboutActivity extends MvvmBaseActivity<UserActivityAboutBinding, AboutViewModel> {

    @Override
    protected int getLayoutId() {
        return R.layout.user_activity_about;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }

    /** 初始化view */
    private void initView() {
        TitleBarUtils.clickLeftBack(viewDataBinding.titleBar, this);
    }

    /** 初始化数据 */
    private void initData() {

    }

    @Override
    protected AboutViewModel getViewModel() {
        return null;
    }

    @Override
    protected int getBindingVariable() {
        return 0;
    }

    @Override
    protected void onRetryBtnClick() {

    }

    /**
     * 启动activity
     *
     * @param context 上下文
     */
    public static void startAction(Context context) {
        context.startActivity(new Intent(context, AboutActivity.class));
    }
}