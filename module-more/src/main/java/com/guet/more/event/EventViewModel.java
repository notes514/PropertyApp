package com.guet.more.event;

import com.guet.base.model.BasePagingModel;
import com.guet.base.model.IPagingModelListener;
import com.guet.base.viewmodel.MvvmBaseViewModel;
import com.guet.common.contract.BaseCustomViewModel;

import java.util.ArrayList;

/**
 * @author dhxstart
 * @date 2022/4/17 15:32
 */
public class EventViewModel extends MvvmBaseViewModel<IEventView, EventModel>
        implements IPagingModelListener<ArrayList<BaseCustomViewModel>> {

    @Override
    public void onLoadFinish(BasePagingModel model, ArrayList<BaseCustomViewModel> data,
                             boolean isEmpty, boolean isFirstPage) {
        if (getPageView() == null) {
            return;
        }
        if (!isEmpty) {
            getPageView().onDataLoadFinish(data, isFirstPage);
            return;
        }

        if (isFirstPage) {
            getPageView().showEmpty();
        } else {
            getPageView().onLoadMoreEmpty();
        }
    }

    @Override
    public void onLoadFail(BasePagingModel model, String prompt,
                           boolean isFirstPage) {
        if (getPageView() == null) {
            return;
        }
        if (isFirstPage) {
            getPageView().showFailure(prompt);
        } else {
            getPageView().onLoadMoreFailure(prompt);
        }
    }

    @Override
    protected void initModel() {
        model = new EventModel();
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
