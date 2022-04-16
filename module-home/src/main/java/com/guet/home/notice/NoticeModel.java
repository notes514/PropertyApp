package com.guet.home.notice;

import com.google.gson.JsonObject;
import com.guet.base.model.BaseModel;
import com.guet.base.utils.GsonUtils;
import com.guet.common.api.ApiInterface;
import com.guet.common.api.CommonResult;
import com.guet.common.api.ResultCode;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.cache.model.CacheMode;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.disposables.Disposable;

/**
 *
 *
 * @author dhxstart
 * @date 2022/4/14 22:58
 */
public class NoticeModel<T> extends BaseModel<T> {
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
