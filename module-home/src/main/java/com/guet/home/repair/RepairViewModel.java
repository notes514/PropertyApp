package com.guet.home.repair;

import android.app.ProgressDialog;

import com.guet.base.model.BaseModel;
import com.guet.base.model.IModelListener;
import com.guet.base.viewmodel.MvvmBaseViewModel;
import com.guet.common.contract.UserInfo;
import com.guet.home.repair.bean.RepairCustomViewModel;
import com.lzy.imagepicker.bean.ImageItem;
import com.zhouyou.http.subsciber.IProgressDialog;

import java.util.ArrayList;

/**
 *
 *
 * @author dhxstart
 * @date 2022/4/14 22:58
 */
public class RepairViewModel extends MvvmBaseViewModel<IRepairView, RepairModel<UserInfo>>
        implements IModelListener<String> {

    @Override
    protected void initModel() {
        model = new RepairModel<>();
        model.register(this);
        model.getCacheDataAndLoad();
        model.load();
    }

    @Override
    public void onLoadFinish(BaseModel model, String token) {
        if (getPageView() == null) {
            return;
        }
        getPageView().onSuccess();
    }


    protected void upload(ArrayList<ImageItem> imageItems, RepairCustomViewModel viewModel, IProgressDialog progressDialog) {
        model.upload(imageItems, viewModel, progressDialog);
    }

    @Override
    public void onLoadFail(BaseModel model, String prompt) {

    }

    @Override
    public void detachUi() {
        super.detachUi();
        if (model != null) {
            model.unRegister(this);
        }
    }
}
