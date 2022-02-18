package com.guet.user.login;

import com.guet.base.activity.IBaseView;

/**
 * @author dhxstart
 * @date 2022/1/3 20:30
 */
public interface ILoginView extends IBaseView {

    /**
     * 登录成功
     *
     * @param token token
     */
    void onLoginSuccess(String token);

    /**
     * 登录失败
     *
     * @param message
     */
    void onLoginFail(String message);
}
