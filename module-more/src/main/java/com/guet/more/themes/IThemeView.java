package com.guet.more.themes;

import java.util.ArrayList;

import com.guet.base.activity.IBaseView;
import com.guet.more.themes.bean.Tabs;

/**
 * 应用模块:
 * <p>
 * 类描述:
 * <p>
 *
 * @author darryrzhoong
 * @since 2020-02-22
 */
public interface IThemeView extends IBaseView {

    /**
     * 数据加载完成
     * @param tabs tabs
     * */
    void onDataLoaded(ArrayList<Tabs> tabs);
}
