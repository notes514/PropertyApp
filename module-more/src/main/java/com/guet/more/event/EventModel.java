package com.guet.more.event;

import com.guet.base.model.BasePagingModel;
import com.guet.base.utils.GsonUtils;
import com.guet.common.api.ApiInterface;
import com.guet.common.contract.BaseCustomViewModel;
import com.guet.common.global.GlobalConstant;
import com.guet.common.global.GlobalKey;
import com.guet.more.event.bean.EventBean;
import com.guet.more.event.bean.EventCustomViewModel;
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
 * 应用模块:
 * <p>
 * 类描述:
 * <p>
 *
 * @author darryrzhoong
 * @since 2020-02-19
 */
public class EventModel<T> extends BasePagingModel<T> {
    private Disposable disposable;
    private int pageNum = 1;

    @Override
    protected void load() {
        disposable = EasyHttp.get(ApiInterface.URL_EVENT_INFO)
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
            List<BaseCustomViewModel> viewModelList = new ArrayList<>();
            for (int i = 0; i < list.length(); i++) {
                JSONObject currentObject = list.getJSONObject(i);
                EventBean bean = GsonUtils.fromLocalJson(currentObject.toString(), EventBean.class);
                if (bean != null) {
                    EventCustomViewModel viewModel = new EventCustomViewModel();
                    viewModel.id = bean.getId();
                    viewModel.title = bean.getTitle();
                    viewModel.content = bean.getContent();
                    viewModel.status = bean.getStatus();
                    viewModel.imageUrl = "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fbkimg.cdn.bcebos.com%2Fpic%2F9d82d158ccbf6c81800ad31e7b76a63533fa838beaa6&refer=http%3A%2F%2Fbkimg.cdn.bcebos.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1652064495&t=640e60969df5187a720cae6d0c102d8d";
                    viewModel.startTime = bean.getStartTime();
                    viewModelList.add(viewModel);
                }
            }
            loadSuccess((T) viewModelList, viewModelList.isEmpty(), isRefresh);
        } catch (JSONException e) {
            e.printStackTrace();
        }
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

    @Override
    public void cancel() {
        super.cancel();
        EasyHttp.cancelSubscription(disposable);
    }
}

