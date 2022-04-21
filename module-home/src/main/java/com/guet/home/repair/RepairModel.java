package com.guet.home.repair;

import androidx.annotation.Nullable;

import com.blankj.utilcode.util.LogUtils;
import com.guet.base.model.BaseModel;
import com.guet.common.api.ApiInterface;
import com.guet.home.repair.bean.RepairCustomViewModel;
import com.lzy.imagepicker.bean.ImageItem;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.body.UIProgressResponseCallBack;
import com.zhouyou.http.cache.model.CacheMode;
import com.zhouyou.http.callback.ProgressDialogCallBack;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;
import com.zhouyou.http.subsciber.IProgressDialog;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import io.reactivex.disposables.Disposable;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;

/**
 *
 *
 * @author dhxstart
 * @date 2022/4/14 22:58
 */
public class RepairModel<T> extends BaseModel<T> {
    private Disposable disposable;

    @Override
    protected void load() {

    }

    protected void upload(ArrayList<ImageItem> imageItems, RepairCustomViewModel model, IProgressDialog progressDialog) {

        final UIProgressResponseCallBack listener = new UIProgressResponseCallBack() {
            @Override
            public void onUIResponseProgress(long bytesRead, long contentLength, boolean done) {
                int progress = (int) (bytesRead * 100 / contentLength);
                LogUtils.d("laodai", "progress：" + progress);
            }
        };
        RequestBody requestBody = new RequestBody() {
            @Nullable
            @Override
            public MediaType contentType() {
                return MediaType.parse("form-data");
            }

            @Override
            public void writeTo(BufferedSink sink) throws IOException {

            }
        };
        File file = new File(imageItems.get(0).path);
        LogUtils.d("laodai", "imageItems.get(0).path：" + imageItems.get(0).path);
        disposable = EasyHttp.post(ApiInterface.URL_IMAGE_UPLOAD)
                .params("file", file, file.getName(), listener)
                .requestBody(requestBody)
                .cacheMode(CacheMode.NO_CACHE)
                .execute(new ProgressDialogCallBack<String>(progressDialog, true, true) {
                    @Override
                    public void onError(ApiException e) {
                        super.onError(e);
                        loadFail(e.getMessage());
                    }

                    @Override
                    public void onSuccess(String response) {
                        parseJson(response, model);
                    }
                });
    }

    private void insert(RepairCustomViewModel model, String imageUrl) {
        disposable = EasyHttp.post(ApiInterface.URL_REPAIR_ADD_REPAIR)
                .params("ownerId", String.valueOf(model.ownerId))
                .params("ownerName", String.valueOf(model.ownerName))
                .params("repairType", String.valueOf(model.repairType))
                .params("repairContent", String.valueOf(model.repairContent))
                .params("imageUrl", imageUrl)
                .cacheMode(CacheMode.NO_CACHE)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        loadFail(e.getMessage());
                    }

                    @Override
                    public void onSuccess(String s) {
                        parseJson1(s);
                    }
                });
    }

    private void parseJson(String str, RepairCustomViewModel model) {
        try {
            JSONObject jsonObject = new JSONObject(str);
            String data = jsonObject.getString("data");
            insert(model, data);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void parseJson1(String str) {
        try {
            JSONObject jsonObject = new JSONObject(str);
            Integer code = jsonObject.getInt("code");
            if (code == 200) {
                loadSuccess((T) code);
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
