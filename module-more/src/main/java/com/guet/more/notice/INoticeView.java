package com.guet.more.notice;

import com.guet.base.activity.IBasePagingView;
import com.guet.common.contract.BaseCustomViewModel;

import java.util.ArrayList;

/**
 *
 *
 * @author dhxstart
 * @date 2022/4/17 15:32
 */
public interface INoticeView extends IBasePagingView {

    /**
     * 数据加载完成
     *
     * @param viewModels data
     */
    void onDataLoadFinish(ArrayList<BaseCustomViewModel> viewModels, boolean isFirstPage);
}
