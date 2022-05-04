package com.guet.user.complaint.fragment;

import com.blankj.utilcode.util.LogUtils;
import com.guet.base.model.BasePagingModel;
import com.guet.base.utils.GsonUtils;
import com.guet.common.api.ApiInterface;
import com.guet.common.contract.BaseCustomViewModel;
import com.guet.common.global.GlobalConstant;
import com.guet.common.global.GlobalKey;
import com.guet.user.complaint.bean.ComplaintBean;
import com.guet.user.complaint.bean.ComplaintCustomViewModel;
import com.guet.user.repair.bean.RepairBean;
import com.guet.user.repair.bean.RepairCustomViewModel;
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
 * RepairModel
 *
 * @author dhxstart
 * @date 2022/1/9 19:41
 */
public class ComplaintModel<T> extends BasePagingModel<T> {
    private Disposable disposable;
    private int pageNum = 1;
    private int position;

    public ComplaintModel(int position) {
        this.position = position;
    }

    @Override
    protected void load() {
        LogUtils.d("laodai", "position：" + position);
        switch (position) {
            case 0:
                listChargeDetail();
                break;
            case 1:
                position = 0;
                likeChargeDetailStatus();
                break;
            case 2:
                position = 1;
                likeChargeDetailStatus();
                break;
            default:
                position = 2;
                likeChargeDetailStatus();
                break;
        }

    }

    private void listChargeDetail() {
        disposable = EasyHttp.get(ApiInterface.URL_LIST_COMPLAINT)
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

    protected void likeChargeDetailStatus() {
        disposable = EasyHttp.get(ApiInterface.URL_LIKE_COMPLAINT)
                .params("status", String.valueOf(position))
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
                ComplaintBean bean = GsonUtils.fromLocalJson(currentObject.toString(), ComplaintBean.class);
                if (bean != null) {
                    ComplaintCustomViewModel viewModel = new ComplaintCustomViewModel();
                    viewModel.id = bean.getId();
                    viewModel.complaintType = bean.getComplaintType();
                    viewModel.complaintContent = bean.getComplaintContent();
                    viewModel.status = "0".equals(bean.getStatus()) ? "待受理" : ("1".equals(bean.getStatus()) ? "受理中" : "已受理");
                    viewModel.gmtCreate = "日期：" + bean.getGmtCreate();
                    viewModels.add(viewModel);
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