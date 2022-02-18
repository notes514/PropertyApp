package com.guet.user.personal;

import android.util.Log;

import com.blankj.utilcode.util.JsonUtils;
import com.blankj.utilcode.util.LogUtils;
import com.guet.base.model.BaseModel;
import com.guet.base.model.BasePagingModel;
import com.guet.base.model.IBaseModelListener;
import com.guet.base.model.IModelListener;
import com.guet.base.model.IPagingModelListener;
import com.guet.base.utils.GsonUtils;
import com.guet.base.viewmodel.MvvmBaseViewModel;
import com.guet.common.api.CommonResult;
import com.guet.common.api.ResultCode;
import com.guet.common.contract.BaseCustomViewModel;
import com.guet.common.contract.UserInfo;
import com.guet.user.personal.bean.UserBean;
import com.guet.user.repair.bean.RepairCustomViewModel;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * UserViewModel
 *
 * @author dhxstart
 * @date 2022/1/20 0:03
 */
public class UserViewModel extends MvvmBaseViewModel<IUserView, UserModel<UserBean>>
        implements IModelListener<UserBean> {

    @Override
    protected void initModel() {
        model = new UserModel<>();
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

    @Override
    public void onLoadFinish(BaseModel model, UserBean userBean) {
        if (getPageView() == null) {
            return;
        }
        getPageView().showUserInfo(userBean);
    }

    @Override
    public void onLoadFail(BaseModel model, String prompt) {

    }

    protected void getUserInfo(String token) {
        model.getUserInfo(token);
    }
}
