package com.guet.user.trade.fragment;

import com.guet.base.activity.IBasePagingView;
import com.guet.common.contract.BaseCustomViewModel;

import java.util.ArrayList;

/**
 * 应用模块:
 * <p>
 * 类描述:
 * <p>
 *
 * @author darryrzhoong
 * @since 2020-02-16
 */
public interface ITradeView extends IBasePagingView {

    /**
     * 数据加载完成
     *
     * @param viewModels data
     * @param isFirstPage 是否是第一页
     */
    void onDataLoadFinish(ArrayList<BaseCustomViewModel> viewModels, boolean isFirstPage);
}
