package com.guet.user.login;

import com.guet.base.model.BaseModel;
import com.guet.base.model.IModelListener;
import com.guet.base.viewmodel.MvvmBaseViewModel;
import com.guet.common.api.ResultCode;
import com.guet.common.contract.BaseCustomViewModel;
import com.guet.common.contract.UserInfo;
import com.guet.user.login.bean.UserBean;

import java.util.ArrayList;

/**
 * LoginViewModel
 *
 * @author dhxstart
 * @date 2022/1/3 20:29
 */
public class LoginViewModel extends MvvmBaseViewModel<ILoginView, LoginModel<UserInfo>>
        implements IModelListener<Integer> {

    @Override
    protected void initModel() {
        model = new LoginModel<>();
        model.register(this);
        model.getCacheDataAndLoad();
        model.load();
    }

    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 密码
     */
    protected void login(String username, String password) {
        model.login(username, password);
    }

    @Override
    public void onLoadFinish(BaseModel model, Integer data) {
        if (getPageView() == null) {
            return;
        }
        if (data != ResultCode.SUCCESS) {
            getPageView().onLoginFail();
        }
        getPageView().onLoginSuccess();
    }

    @Override
    public void onLoadFail(BaseModel model, String prompt) {
        if (getPageView() != null) {
            getPageView().showFailure(prompt);
        }
    }

    @Override
    public void detachUi() {
        super.detachUi();
        if (model != null) {
            model.unRegister(this);
        }
    }
}
