package com.guet.home.notice;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.lifecycle.ViewModelProviders;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.LogUtils;
import com.guet.base.activity.MvvmBaseActivity;
import com.guet.common.adapter.ScreenAutoAdapter;
import com.guet.common.router.RouterActivityPath;
import com.guet.common.utils.TitleBarUtils;
import com.guet.home.R;
import com.guet.home.databinding.HomeActivityNoticeBinding;

/**
 *
 *
 * @author dhxstart
 * @date 2022/4/14 22:56
 */
@Route(path = RouterActivityPath.Home.PAGE_NOTICE)
public class NoticeActivity extends MvvmBaseActivity<HomeActivityNoticeBinding, NoticeViewModel>
        implements INoticeView {
    private static final String TAG = "NoticeActivity";

    @Autowired(name = "noticeViewModel")
    public com.guet.home.nominate.bean.viewmodel.NoticeViewModel noticeViewModel;

    @Override
    protected int getLayoutId() {
        return R.layout.home_activity_notice;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ScreenAutoAdapter.match(this, 375.0f);
        super.onCreate(savedInstanceState);
        // ARouter inject 注入
        ARouter.getInstance().inject(this);
        if (noticeViewModel != null) {
            viewDataBinding.setViewModel(noticeViewModel);
            LogUtils.dTag(TAG, "title：" + noticeViewModel.title);
        }
        viewDataBinding.included.titleBar.setTitle(R.string.home_notice_title);
        TitleBarUtils.clickLeftBack(viewDataBinding.included.titleBar, this);
    }

    @Override
    protected NoticeViewModel getViewModel() {
        return ViewModelProviders.of(this).get(NoticeViewModel.class);
    }

    @Override
    protected int getBindingVariable() {
        return 0;
    }

    @Override
    protected void onRetryBtnClick() {

    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
