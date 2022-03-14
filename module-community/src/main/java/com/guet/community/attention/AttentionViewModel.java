package com.guet.community.attention;

import com.guet.base.model.BasePagingModel;
import com.guet.base.model.IPagingModelListener;
import com.guet.base.viewmodel.MvvmBaseViewModel;
import com.guet.common.contract.BaseCustomViewModel;

import java.util.ArrayList;


/**
 * 应用模块:
 * <p>
 * 类描述:
 * <p>
 *
 * @author darryrzhoong
 * @since 2020-02-19
 */
public class AttentionViewModel extends MvvmBaseViewModel<IAttentionView, AttentionModel>
        implements IPagingModelListener<ArrayList<BaseCustomViewModel>> {

    @Override
    public void onLoadFinish(BasePagingModel model, ArrayList<BaseCustomViewModel> data,
                             boolean isEmpty, boolean isFirstPage) {
        if (getPageView() != null) {
            if (isEmpty) {
                if (isFirstPage) {
                    getPageView().showEmpty();
                } else {
                    getPageView().onLoadMoreEmpty();
                }
            } else {
                getPageView().onDataLoadFinish(data, isFirstPage);
            }
        }
    }

    @Override
    public void onLoadFail(BasePagingModel model, String prompt,
                           boolean isFirstPage) {
        if (getPageView() != null) {
            if (isFirstPage) {
                getPageView().showFailure(prompt);
            } else {
                getPageView().onLoadMoreFailure(prompt);
            }
        }
    }

    @Override
    protected void initModel() {
        model = new AttentionModel();
        model.register(this);
        model.getCacheDataAndLoad();
    }

    @Override
    public void detachUi() {
        super.detachUi();
        if (model != null) {
            model.unRegister(this);
        }
    }

    public void tryRefresh() {
        model.refresh();
    }

    public void loadMore() {
        model.loadMore();
    }
}
