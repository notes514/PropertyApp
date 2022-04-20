package com.guet.more.notice.details;

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
import com.guet.more.R;
import com.guet.more.databinding.MoreActivityEventDetailsBinding;
import com.guet.more.databinding.MoreActivityNoticeDetailsBinding;
import com.guet.more.notice.bean.NoticeCustomViewModel;

/**
 *
 *
 * @author dhxstart
 * @date 2022/4/14 22:56
 */
@Route(path = RouterActivityPath.More.PAGE_NOTICE_DETAILS)
public class NoticeDetailsActivity extends MvvmBaseActivity<MoreActivityNoticeDetailsBinding, NoticeDetailsViewModel>
        implements INoticeDetailsView {
    private static final String TAG = "NoticeActivity";

    @Autowired(name = "noticeCustomViewModel")
    public NoticeCustomViewModel viewModel;

    @Override
    protected int getLayoutId() {
        return R.layout.more_activity_notice_details;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ScreenAutoAdapter.match(this, 375.0f);
        super.onCreate(savedInstanceState);
        // ARouter inject 注入
        ARouter.getInstance().inject(this);
        if (viewModel != null) {
            viewDataBinding.setViewModel(viewModel);
            LogUtils.dTag(TAG, "title：" + viewModel.title);
        }
        viewDataBinding.included.titleBar.setTitle("活动详情");
        TitleBarUtils.clickLeftBack(viewDataBinding.included.titleBar, this);
    }

    @Override
    protected NoticeDetailsViewModel getViewModel() {
        return ViewModelProviders.of(this).get(NoticeDetailsViewModel.class);
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
