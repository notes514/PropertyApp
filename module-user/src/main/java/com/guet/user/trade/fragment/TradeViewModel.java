package com.guet.user.trade.fragment;

import com.guet.base.model.BasePagingModel;
import com.guet.base.model.IPagingModelListener;
import com.guet.base.viewmodel.MvvmBaseViewModel;
import com.guet.common.contract.BaseCustomViewModel;
import com.guet.user.repair.bean.RepairCustomViewModel;

import java.util.ArrayList;

/**
 * RepairViewModel
 *
 * @author dhxstart
 * @date 2022/1/8 22:16
 */
public class TradeViewModel extends MvvmBaseViewModel<ITradeView, TradeModel>
        implements IPagingModelListener<ArrayList<BaseCustomViewModel>> {

    @Override
    protected void initModel() {
        model.register(this);
        model.getCacheDataAndLoad();
    }

    protected void initModel(int position) {
        model = new TradeModel<RepairCustomViewModel>(position);
        initModel();
    }

    @Override
    public void detachUi() {
        super.detachUi();
        if (model != null) {
            model.unRegister(this);
        }
    }

    /** 尝试刷新 */
    public void tryRefresh() {
        model.refresh();
    }

    /** 加载更多 */
    public void loadMore() {
        model.loadMore();
    }

    @Override
    public void onLoadFinish(BasePagingModel model, ArrayList<BaseCustomViewModel> data,
                             boolean isEmpty, boolean isFirstPage) {
        if (getPageView() == null) {
            return;
        }
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

    @Override
    public void onLoadFail(BasePagingModel model, String prompt, boolean isFirstPage) {
        if (getPageView() == null) {
            return;
        }
        if (isFirstPage) {
            getPageView().showFailure(prompt);
        } else {
            getPageView().onLoadMoreFailure(prompt);
        }
    }
}
