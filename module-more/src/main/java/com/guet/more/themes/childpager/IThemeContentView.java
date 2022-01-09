package com.guet.more.themes.childpager;

import java.util.ArrayList;

import com.guet.base.activity.IBasePagingView;
import com.guet.common.contract.BaseCustomViewModel;

/**
 * 应用模块:
 * <p>
 * 类描述:
 * <p>
 *
 * @author darryrzhoong
 * @since 2020-02-23
 */
public interface IThemeContentView extends IBasePagingView {

    /**
     * 数据加载完成
     * @param viewModels data
     * @param isFirstPage 是否是第一页数据
     * */
    void onDataLoaded(ArrayList<BaseCustomViewModel> viewModels, boolean isFirstPage);
}
