package com.guet.user.services;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.guet.common.contract.UserInfo;
import com.guet.common.router.RouterActivityPath;
import com.guet.common.services.ILoginService;
import com.guet.common.services.config.ServicesConfig;

/**
 * 用户登录信息服务类 为各个组件提供app登录信息
 *
 * @author dhxstart
 * @date 2022/1/3 18:30
 */
@Route(path = ServicesConfig.User.LONGING_SERVICE, name = "登录服务")
public class ILoginServiceImpl implements ILoginService {
    private boolean loginStatus;

    @Override
    public boolean saveStatus(boolean status) {
        this.loginStatus = status;
        return status;
    }

    @Override
    public boolean isLogin() {
        return loginStatus;
    }

    @Override
    public String getToken() {
        return null;
    }

    @Override
    public String getUUID() {
        return null;
    }

    @Override
    public void refreshUserDetailInfo() {

    }

    @Override
    public void login() {
        ARouter.getInstance()
                .build(RouterActivityPath.User.PAGER_LOGIN)
                .navigation();
    }

    @Override
    public void login(boolean isMainAccountLogin) {

    }

    @Override
    public void logout() {

    }

    @Override
    public UserInfo getUserInfo() {

        return UserInfo.getInstance();
    }

    @Override
    public void onLoginCancel() {

    }

    @Override
    public void onTokenExpire() {

    }

    @Override
    public void init(Context context) {

    }
}
