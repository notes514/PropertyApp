package com.guet.user.personal;

import com.guet.base.activity.IBasePagingView;
import com.guet.base.activity.IBaseView;
import com.guet.common.contract.BaseCustomViewModel;
import com.guet.common.contract.UserInfo;
import com.guet.user.personal.bean.UserBean;

import java.util.ArrayList;

/**
 * 应用模块：user
 *
 * @author dhxstart
 * @date 2022/1/20 0:12
 */
public interface IUserView extends IBaseView {

    /**
     * 显示用户信息
     *
     * @param userBean 用户信息
     */
    void showUserInfo(UserBean userBean);
}
