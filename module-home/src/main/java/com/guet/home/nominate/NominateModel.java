package com.guet.home.nominate;

import android.text.TextUtils;
import android.util.Log;

import com.blankj.utilcode.util.LogUtils;
import com.guet.base.model.BasePagingModel;
import com.guet.base.utils.GsonUtils;
import com.guet.common.api.ApiInterface;
import com.guet.common.api.CommonResult;
import com.guet.common.api.ResultCode;
import com.guet.common.contract.BaseCustomViewModel;
import com.guet.common.global.GlobalConstant;
import com.guet.common.global.GlobalKey;
import com.guet.home.nominate.bean.NoticeBean;
import com.guet.home.nominate.bean.viewmodel.NoticeViewModel;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.cache.model.CacheMode;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.Disposable;

/**
 * 应用模块: 首页
 * <p>
 * 类描述: 首页 业务逻辑 处理中心
 * <p>
 *
 * @author darryrzhoong
 * @since 2020-02-10
 */
public class NominateModel<T> extends BasePagingModel<T> {
    private static final String TAG = "NominateModel";
    private Disposable disposable;
    private int pageNum = 1;

    @Override
    protected void load() {
        disposable = EasyHttp.get(ApiInterface.URL_NOTICE_INFO)
                .params(GlobalKey.PAGE_NUM, String.valueOf(pageNum))
                .params(GlobalKey.PAGE_ROW, String.valueOf(GlobalConstant.PAGE_NUM))
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

    private void parseJson(String data) {
        try {
            JSONObject jsonObject = new JSONObject(data);
            String dataObj = jsonObject.getString("data");
            jsonObject = new JSONObject(dataObj);
            JSONArray list = jsonObject.optJSONArray("list");
            if (list == null) {
                hasNextPage = false;
                return;
            }
            hasNextPage = true;
            List<BaseCustomViewModel> viewModels = new ArrayList<>();
            for (int i = 0; i < list.length(); i++) {
                JSONObject currentObject = list.getJSONObject(i);
                NoticeBean bean = GsonUtils.fromLocalJson(currentObject.toString(), NoticeBean.class);
                if (bean != null) {
                    NoticeViewModel noticeViewModel = new NoticeViewModel();
                    noticeViewModel.id = bean.getId();
                    noticeViewModel.title = bean.getTitle();
                    noticeViewModel.content = bean.getContent();
                    noticeViewModel.status = bean.getStatus();
                    noticeViewModel.releaseTime = bean.getReleaseTime();
                    noticeViewModel.imageUrl = bean.getImageUrl();
                    viewModels.add(noticeViewModel);
                }
            }
            loadSuccess((T) viewModels, viewModels.isEmpty(), isRefresh);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cancel() {
        super.cancel();
        EasyHttp.cancelSubscription(disposable);
    }

    public void refresh() {
        isRefresh = true;
        pageNum = 1;
        load();
    }

    public void loadMore() {
        isRefresh = false;
        if (!hasNextPage) {
            loadSuccess(null, true, false);
            return;
        }
        pageNum++;
        load();
    }
}
