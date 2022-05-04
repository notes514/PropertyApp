package com.guet.community.supply.details;

import com.guet.base.model.BaseModel;
import com.zhouyou.http.EasyHttp;

import io.reactivex.disposables.Disposable;

/**
 *
 *
 * @author dhxstart
 * @date 2022/4/14 22:58
 */
public class SupplyDetailsModel<T> extends BaseModel<T> {
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
