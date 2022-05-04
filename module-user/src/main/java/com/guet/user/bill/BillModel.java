package com.guet.user.bill;

import com.guet.base.model.BaseModel;
import com.guet.common.api.ApiInterface;
import com.guet.user.bill.bean.BillCustomViewModel;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.cache.model.CacheMode;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.disposables.Disposable;

/**
 * RepairModel
 *
 * @author dhxstart
 * @date 2022/1/8 11:22
 */
public class BillModel<T> extends BaseModel<T> {
    private Disposable disposable;

    @Override
    protected void load() {
        disposable = EasyHttp.get(ApiInterface.URL_LIST_CHARGE_DETAIL)
                .cacheMode(CacheMode.NO_CACHE)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        loadFail(e.getMessage());
                    }

                    @Override
                    public void onSuccess(String s) {
                        parseJson(s);
                    }
                });
    }

    protected void likeChargeDetailStatus() {
        disposable = EasyHttp.get(ApiInterface.URL_LIKE_CHARGE_DETAIL_STATUS)
                .cacheMode(CacheMode.NO_CACHE)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        loadFail(e.getMessage());
                    }

                    @Override
                    public void onSuccess(String s) {
                        parseJson(s);
                    }
                });
    }

    private void parseJson(String str) {
        try {
            JSONObject jsonObject = new JSONObject(str);
            Integer data = jsonObject.getInt("code");
            if (data == 200) {
                loadSuccess((T) data);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void cancel() {
        super.cancel();
        EasyHttp.cancelSubscription(disposable);
    }
}
