package com.guet.user.regist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProviders;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.guet.base.activity.MvvmBaseActivity;
import com.guet.base.storage.MmkvHelper;
import com.guet.base.utils.ToastUtil;
import com.guet.common.router.RouterActivityPath;
import com.guet.user.login.LoginActivity;
import com.guet.user.view.DLAnimView;
import com.guet.user.R;
import com.guet.user.databinding.UserActivityRegistBinding;
import com.gyf.immersionbar.ImmersionBar;
import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;

/**
 * 注册 Activity
 *
 * @author dhxstart
 * @date 2022/1/3 21:43
 */
@Route(path = RouterActivityPath.User.PAGER_LOGIN)
public class RegistActivity extends MvvmBaseActivity<UserActivityRegistBinding, RegistViewModel> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 设置状态栏和导航栏颜色
        ImmersionBar.with(this)
                .statusBarColor(R.color.white)
                .navigationBarColor(R.color.white)
                .fitsSystemWindows(true)
                .autoDarkModeEnable(true)
                .init();
        ARouter.getInstance().inject(this);
        initView();
        initData();
    }

    /** 初始化数据 */
    private void initData() {
    }

    /** 初始化view */
    private void initView() {
        // 设置登录背景图片
        DLAnimView dlAnimView = new DLAnimView(this);
        ConstraintLayout.LayoutParams layoutParams =
                new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT,
                        ConstraintLayout.LayoutParams.MATCH_PARENT);
        viewDataBinding.registBgLayout.addView(dlAnimView, layoutParams);

        viewDataBinding.titleBar.setOnTitleBarListener(new OnTitleBarListener() {

            @Override
            public void onLeftClick(TitleBar titleBar) {
                finish();
            }
        });

        viewDataBinding.btnRegist.setOnClickListener(v -> {
            if (TextUtils.isEmpty(viewDataBinding.editUsername.getText().toString())) {
                ToastUtil.show(this, "用户名不能为空！");
            } else if (TextUtils.isEmpty(viewDataBinding.editPhone.getText().toString())) {
                ToastUtil.show(this, "手机号不能为空！");
            } else if (TextUtils.isEmpty(viewDataBinding.editPassword.getText().toString())) {
                ToastUtil.show(this, "密码不能为空！");
            } else {
                LogUtils.d("执行了注册操作！");
            }
        });

        viewDataBinding.tvLogin.setOnClickListener(v -> finish());
    }

    /**
     * 启动注册activity
     *
     * @param context 上下文
     */
    public static void startAction(Context context) {
        MmkvHelper.getInstance().getMmkv().encode("first", false);
        context.startActivity(new Intent(context, RegistActivity.class));
    }

    @Override
    protected RegistViewModel getViewModel() {
        return ViewModelProviders.of(this).get(RegistViewModel.class);
    }

    @Override
    protected int getBindingVariable() {
        return 0;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.user_activity_regist;
    }

    @Override
    protected void onRetryBtnClick() {

    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
