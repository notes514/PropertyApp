package com.guet.home.suggestions;

import com.guet.base.model.BaseModel;
import com.guet.common.api.ApiInterface;
import com.guet.home.repair.bean.RepairCustomViewModel;
import com.guet.home.suggestions.bean.SuggestionsCustomViewModel;
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
public class SuggestionsModel<T> extends BaseModel<T> {
    private Disposable disposable;

    @Override
    protected void load() {
    }

    protected void insert(SuggestionsCustomViewModel viewModel) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("ownerName", "李小锋");
            jsonObject.put("complaintType", viewModel.complaintType);
            jsonObject.put("complaintContent", viewModel.complaintContent);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        disposable = EasyHttp.post(ApiInterface.URL_COMPLAINT_ADD_COMPLAINT)
                .upJson(jsonObject.toString())
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
