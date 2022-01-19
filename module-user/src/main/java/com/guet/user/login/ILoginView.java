package com.guet.user.login;

import com.guet.base.activity.IBaseView;
import com.guet.common.contract.BaseCustomViewModel;

import java.util.ArrayList;

/**
 * @author dhxstart
 * @date 2022/1/3 20:30
 */
public interface ILoginView extends IBaseView {

    /**
     * 登录成功
     */
    void onLoginSuccess();

    /**
     * 登录失败
     */
    void onLoginFail();
}
