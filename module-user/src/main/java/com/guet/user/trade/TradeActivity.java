package com.guet.user.trade;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.ToastUtils;
import com.google.android.material.tabs.TabLayoutMediator;
import com.guet.base.activity.MvvmBaseActivity;
import com.guet.common.router.RouterActivityPath;
import com.guet.common.utils.TitleBarUtils;
import com.guet.user.R;
import com.guet.user.adapter.UserFragmentPageAdapter;
import com.guet.user.databinding.UserActivityViewBinding;
import com.guet.user.trade.fragment.TradeFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * RepairActivity
 *
 * @author dhxstart
 * @date 2022/1/8 14:52
 */
@Route(path = RouterActivityPath.User.PAGER_TRADE)
public class TradeActivity extends MvvmBaseActivity<UserActivityViewBinding, TradeViewModel> {

    private final String[] tabs = new String[]{"全部", "未开始", "进行中", "已结束"};
    private UserFragmentPageAdapter mAdapter;
    private final int activeColor = Color.parseColor("#ff678f");
    private final int normalColor = Color.parseColor("#666666");
    private final int normalSize = 16;

    @Override
    protected TradeViewModel getViewModel() {
        return null;
    }

    @Override
    protected int getBindingVariable() {
        return 0;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.user_activity_view;
    }

    @Override
    protected void onRetryBtnClick() {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }

    /**
     * 初始化view
     */
    private void initView() {
        mAdapter = new UserFragmentPageAdapter(getSupportFragmentManager(), getLifecycle());
        // 禁用预加载
        viewDataBinding.viewPager.setOffscreenPageLimit(ViewPager2.OFFSCREEN_PAGE_LIMIT_DEFAULT);
        // 页面切换监听
        viewDataBinding.viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
            }
        });
        viewDataBinding.viewPager.setAdapter(mAdapter);
        viewDataBinding.fabAdd.setOnClickListener(v -> ToastUtils.showShort("点击了悬浮按钮！！！"));

        viewDataBinding.included.titleBar.setTitle("我的交易信息");
        TitleBarUtils.clickLeftBack(viewDataBinding.included.titleBar, this);
    }

    /**
     * 初始化data
     */
    private void initData() {
        List<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < tabs.length; i++) {
            fragments.add(TradeFragment.newInstance(i));
        }
        mAdapter.setData(fragments);

        new TabLayoutMediator(viewDataBinding.tabLayout, viewDataBinding.viewPager,
                (tab, position) -> {
                    TextView tabView = new TextView(TradeActivity.this);
                    int[][] states = new int[2][];
                    states[0] = new int[]{android.R.attr.state_selected};
                    states[1] = new int[]{};

                    int[] colors = new int[]{activeColor, normalColor};
                    ColorStateList colorStateList = new ColorStateList(states, colors);
                    tabView.setText(tabs[position]);
                    tabView.setTextSize(normalSize);
                    tabView.setTextColor(colorStateList);
                    tabView.setGravity(Gravity.CENTER);
                    tab.setCustomView(tabView);
                }).attach();
    }

    /**
     * 启动activity
     *
     * @param context 上下文
     */
    public static void startAction(Context context) {
        context.startActivity(new Intent(context, TradeActivity.class));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}