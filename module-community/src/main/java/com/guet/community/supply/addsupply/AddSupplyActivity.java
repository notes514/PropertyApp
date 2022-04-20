package com.guet.community.supply.addsupply;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.lifecycle.ViewModelProviders;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.guet.base.activity.MvvmBaseActivity;
import com.guet.common.adapter.ScreenAutoAdapter;
import com.guet.common.router.RouterActivityPath;
import com.guet.common.utils.TitleBarUtils;
import com.guet.community.R;
import com.guet.community.databinding.CommunityActivityAddSupplyBinding;

/**
 *
 *
 * @author dhxstart
 * @date 2022/4/14 22:56
 */
@Route(path = RouterActivityPath.Community.PAGE_ADD_SUPPLY)
public class AddSupplyActivity extends MvvmBaseActivity<CommunityActivityAddSupplyBinding, AddSupplyViewModel>
        implements IAddSupplyView {
    private static final String TAG = "AddSupplyActivity";

    @Override
    protected int getLayoutId() {
        return R.layout.community_activity_add_supply;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ScreenAutoAdapter.match(this, 375.0f);
        super.onCreate(savedInstanceState);
        // ARouter inject 注入
        ARouter.getInstance().inject(this);
        viewDataBinding.included.titleBar.setTitle("添加商品");
        TitleBarUtils.clickLeftBack(viewDataBinding.included.titleBar, this);
    }

    @Override
    protected AddSupplyViewModel getViewModel() {
        return ViewModelProviders.of(this).get(AddSupplyViewModel.class);
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
