package com.guet.user.login;

import com.blankj.utilcode.util.LogUtils;
import com.google.gson.Gson;
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

import java.util.HashMap;
import java.util.Map;

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

    protected void login(String username, String password) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("username", username);
        jsonObject.addProperty("password", password);
        disposable = EasyHttp.post(ApiInterface.URL_LOGIN)
                .upJson(jsonObject.toString())
                .cacheMode(CacheMode.NO_CACHE)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        loadFail(e.getMessage());
                    }

                    @Override
                    public void onSuccess(String s) {
                        CommonResult result = GsonUtils.fromLocalJson(s, CommonResult.class);
                        if (result == null) {
                            return;
                        }
                        if (result.getCode() != ResultCode.SUCCESS) {
                            loadFail(result.getMessage());
                            return;
                        }
                        try {
                            JSONObject jsonObject = new JSONObject(result.getData().toString());
                            loadSuccess((T) jsonObject.getString("token"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    @Override
    public void cancel() {
        super.cancel();
        EasyHttp.cancelSubscription(disposable);
    }
}
