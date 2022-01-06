package com.guet.user.login;

import com.guet.base.model.BaseModel;
import com.guet.base.model.IModelListener;
import com.guet.base.viewmodel.MvvmBaseViewModel;
import com.guet.common.contract.BaseCustomViewModel;
import com.guet.user.login.bean.UserBean;

import java.util.ArrayList;

/**
 * LoginViewModel
 *
 * @author dhxstart
 * @date 2022/1/3 20:29
 */
public class LoginViewModel extends MvvmBaseViewModel<ILoginView, LoginModel<UserBean>>
        implements IModelListener<ArrayList<BaseCustomViewModel>> {

    @Override
    protected void initModel() {
        model = new LoginModel<>();
        model.register(this);
        model.getCacheDataAndLoad();
        model.load();
    }

    @Override
    public void onLoadFinish(BaseModel model, ArrayList<BaseCustomViewModel> data) {
        if (getPageView() != null) {
            if (data != null && data.size() > 0) {
                getPageView().onDataLoadFinish(data, false);
            } else {
                getPageView().showEmpty();
            }
        }
    }

    @Override
    public void onLoadFail(BaseModel model, String prompt) {
        if (getPageView() != null) {
            getPageView().showFailure(prompt);
        }
    }

    @Override
    public void detachUi() {
        super.detachUi();
        if (model != null) {
            model.unRegister(this);
        }
    }
}
