package com.guet.user.bill.fragment;

import android.annotation.SuppressLint;

import com.guet.base.model.BasePagingModel;
import com.guet.base.utils.GsonUtils;
import com.guet.common.api.ApiInterface;
import com.guet.common.contract.BaseCustomViewModel;
import com.guet.common.global.GlobalConstant;
import com.guet.common.global.GlobalKey;
import com.guet.user.bill.bean.BillBean;
import com.guet.user.bill.bean.BillCustomViewModel;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.cache.model.CacheMode;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.Disposable;

/**
 * RepairModel
 *
 * @author dhxstart
 * @date 2022/1/9 19:41
 */
public class BillModel<T> extends BasePagingModel<T> {
    private static final String TAG = "NominateModel";
    private Disposable disposable;
    private int pageNum = 1;
    private int position;

    public BillModel(int position) {
        this.position = position;
    }

    @Override
    protected void load() {
        switch (position) {
            case 0:
                listChargeDetail();
                break;
            case 1:
                position = 0;
                likeChargeDetailStatus();
                break;
            default:
                position = 1;
                likeChargeDetailStatus();
                break;
        }

    }

    private void listChargeDetail() {
        disposable = EasyHttp.get(ApiInterface.URL_LIST_CHARGE_DETAIL)
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
        disposable = EasyHttp.get(ApiInterface.URL_LIKE_CHARGE_DETAIL_STATUS)
                .params("payStatus", String.valueOf(position))
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
            @SuppressLint("SimpleDateFormat")
            SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
            for (int i = 0; i < list.length(); i++) {
                JSONObject currentObject = list.getJSONObject(i);
                BillBean bean = GsonUtils.fromLocalJson(currentObject.toString(), BillBean.class);
                if (bean != null) {
                    BillCustomViewModel noticeViewModel = new BillCustomViewModel();
                    noticeViewModel.id = bean.getId();
                    noticeViewModel.chargeName = bean.getChargeName();
                    noticeViewModel.chargeStandard =  "金额：" + bean.getChargeStandard();
                    noticeViewModel.payReal = bean.getPayReal();
                    noticeViewModel.payStatus = "0".equals(bean.getPayStatus()) ? "未缴费" : "已缴费";
                    noticeViewModel.payTime = bean.getPayTime();
                    noticeViewModel.gmtCreate = "日期：" + bean.getGmtCreate();
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
