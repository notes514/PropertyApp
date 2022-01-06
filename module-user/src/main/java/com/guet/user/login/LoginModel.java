package com.guet.user.login;

import com.guet.base.model.BaseModel;
import com.zhouyou.http.EasyHttp;

import io.reactivex.disposables.Disposable;

/**
 * LoginModel
 *
 * @author dhxstart
 * @date 2022/1/3 20:28
 */
public class LoginModel<T> extends BaseModel<T> {

    private Disposable disposable;

    @Override
    protected void load() {
    }

    @Override
    public void cancel() {
        super.cancel();
        EasyHttp.cancelSubscription(disposable);
    }
}
