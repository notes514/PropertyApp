package com.guet.community.attention;

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
 * @since 2020-02-19
 */
public interface IAttentionView extends IBasePagingView {

    /**
     * 数据加载完成
     *
     * @param viewModels data
     */
    void onDataLoadFinish(ArrayList<BaseCustomViewModel> viewModels, boolean isFirstPage);
}
