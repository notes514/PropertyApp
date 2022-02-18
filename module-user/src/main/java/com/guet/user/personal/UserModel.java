package com.guet.user.personal;

import com.blankj.utilcode.util.GsonUtils;
import com.blankj.utilcode.util.JsonUtils;
import com.guet.base.model.BaseModel;
import com.guet.common.api.ApiInterface;
import com.guet.common.api.CommonResult;
import com.guet.common.api.ResultCode;
import com.guet.user.personal.bean.UserBean;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.cache.model.CacheMode;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import io.reactivex.disposables.Disposable;

/**
 * UserModel
 *
 * @author dhxstart
 * @date 2022/1/9 19:41
 */
public class UserModel<T> extends BaseModel<T> {
    private Disposable disposable;

    @Override
    protected void load() {

    }

    protected void getUserInfo(String token) {
        disposable = EasyHttp.post(ApiInterface.URL_USER_INFO)
                .headers("token", token)
                .cacheMode(CacheMode.DEFAULT)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        loadFail(e.getMessage());
                    }

                    @Override
                    public void onSuccess(String s) {
                        CommonResult result = GsonUtils.fromJson(s, CommonResult.class);
                        if (result == null) {
                            return;
                        }
                        if (result.getCode() != ResultCode.SUCCESS) {
                            loadFail(result.getMessage());
                            return;
                        }
                        String data = JsonUtils.getString(s, ResultCode.RESULT_DATA);
                        UserBean userBean = GsonUtils.fromJson(data, UserBean.class);
                        loadSuccess((T) userBean);
                    }
                });
    }

    @Override
    public void cancel() {
        super.cancel();
        EasyHttp.cancelSubscription(disposable);
    }
}
