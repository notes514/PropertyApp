package com.guet.user.login;

import com.guet.base.activity.IBaseView;
import com.guet.common.contract.BaseCustomViewModel;

import java.util.ArrayList;

/**
 * @author dhxstart
 * @date 2022/1/3 20:30
 */
public interface ILoginView extends IBaseView {

    /**
     * 数据加载完成
     *
     * @param viewModels data
     * @param isEmpty 是否为空
     */
    void onDataLoadFinish(ArrayList<BaseCustomViewModel> viewModels, boolean isEmpty);
}
