package com.guet.home.nominate;

import com.blankj.utilcode.util.LogUtils;
import com.guet.base.model.BasePagingModel;
import com.guet.base.model.IPagingModelListener;
import com.guet.base.viewmodel.MvvmBaseViewModel;
import com.guet.common.contract.BaseCustomViewModel;

import java.util.ArrayList;

/**
 * 应用模块: 首页
 * <p>
 * 类描述: 处理业务结果 & UI刷新
 * <p>
 *
 * @author darryrzhoong
 * @since 2020-02-10
 */
public class NominateViewModel extends MvvmBaseViewModel<INominateView, NominateModel>
        implements IPagingModelListener<ArrayList<BaseCustomViewModel>> {

    @Override
    public void onLoadFinish(BasePagingModel model, ArrayList<BaseCustomViewModel> data,
                             boolean isEmpty, boolean isFirstPage) {
        if (getPageView() == null) {
            return;
        }
        if (!isEmpty){
            getPageView().onDataLoadFinish(data, isFirstPage);
            return;
        }
        // 是否是上拉刷新
        if (isFirstPage) {
            // 显示空页面
            getPageView().showEmpty();
            return;
        }
        // 没有更多了
        getPageView().onLoadMoreEmpty();
    }

    @Override
    public void onLoadFail(BasePagingModel model, String prompt, boolean isFirstPage) {
        if (getPageView() == null) {
            return;
        }
        if (isFirstPage) {
            // 刷新失败
            getPageView().showFailure(prompt);
        } else {
            // 加载更多失败
            getPageView().onLoadMoreFailure(prompt);
        }
    }

    @Override
    protected void loadData() {
        model.loadMore();
    }

    @Override
    protected void initModel() {
        model = new NominateModel<>();
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

    public void tryToRefresh() {
        model.refresh();
    }
}
