package com.guet.user.login;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProviders;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.guet.base.activity.MvvmBaseActivity;
import com.guet.base.storage.MmkvHelper;
import com.guet.base.utils.ToastUtil;
import com.guet.common.router.RouterActivityPath;
import com.guet.common.services.ILoginService;
import com.guet.common.services.config.ServicesConfig;
import com.guet.common.utils.TitleBarUtils;
import com.guet.user.view.DLAnimView;
import com.guet.user.R;
import com.guet.user.databinding.UserActivityLoginBinding;
import com.guet.user.regist.RegistActivity;

import java.util.Objects;

/**
 * 登录 Activity
 *
 * @author dhxstart
 * @date 2022/1/3 21:43
 */
@Route(path = RouterActivityPath.User.PAGER_LOGIN)
public class LoginActivity extends MvvmBaseActivity<UserActivityLoginBinding, LoginViewModel>
        implements ILoginView {

    @Autowired(name = ServicesConfig.User.LONGING_SERVICE)
    ILoginService iLoginService;
    private AlertDialog alertDialog;

    @Override
    protected int getLayoutId() {
        return R.layout.user_activity_login;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ARouter.getInstance().inject(this);
        initView();
        initData();
    }

    @Override
    protected LoginViewModel getViewModel() {
        return ViewModelProviders.of(this).get(LoginViewModel.class);
    }

    /** 初始化view */
    private void initView() {
        // 设置登录背景图片
        DLAnimView dlAnimView = new DLAnimView(this);
        ConstraintLayout.LayoutParams layoutParams =
                new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT,
                        ConstraintLayout.LayoutParams.MATCH_PARENT);
        viewDataBinding.loginBgLayout.addView(dlAnimView, layoutParams);

        TitleBarUtils.clickLeftBack(viewDataBinding.included.titleBar, this);

        viewDataBinding.btnLogin.setOnClickListener(v -> {
            String username = Objects.requireNonNull(viewDataBinding.editUsername.getText()).toString();
            String password = Objects.requireNonNull(viewDataBinding.editPassword.getText()).toString();
            if (TextUtils.isEmpty(username)) {
                ToastUtil.show(this, "用户名不能为空！");
                return ;
            }
            if (TextUtils.isEmpty(password)) {
                ToastUtil.show(this, "密码不能为空！");
                return ;
            }
            alertDialog = new AlertDialog.Builder(this)
                    .setView(R.layout.user_layout_loading_trips)
                    .show();
            viewModel.login(username, password);
        });

        viewDataBinding.tvForgotPassword.setOnClickListener(v -> {
            ToastUtil.show(this, "忘记密码！！！");
        });

        viewDataBinding.tvRegist.setOnClickListener(v -> {
            ToastUtil.show(this, "注册！！！");
            RegistActivity.startAction(this);
        });
    }

    /** 初始化数据 */
    private void initData() {
        //模拟登录
        iLoginService.saveStatus(false);
        viewModel.initModel();
        viewDataBinding.included.titleBar.setTitle(R.string.login);
//        viewDataBinding.editUsername.setText("admin");
//        viewDataBinding.editPassword.setText("123456");
    }

    /**
     * 启动登录activity
     *
     * @param context 上下文
     */
    public static void startAction(Context context) {
        MmkvHelper.getInstance().getMmkv().encode("first", false);
        context.startActivity(new Intent(context, LoginActivity.class));
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

    @Override
    public void onLoginSuccess(String token) {
        iLoginService.saveStatus(true);
        alertDialog.dismiss();
        Intent intent = new Intent();
        intent.putExtra("token", token);
        intent.putExtra("user", "login_success");
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    public void onLoginFail(String message) {
        alertDialog.dismiss();
        ToastUtil.show(this, message);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
