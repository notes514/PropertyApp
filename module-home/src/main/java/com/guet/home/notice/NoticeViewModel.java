package com.guet.home.notice;

import com.guet.base.model.BaseModel;
import com.guet.base.model.IModelListener;
import com.guet.base.viewmodel.MvvmBaseViewModel;
import com.guet.common.contract.UserInfo;

/**
 *
 *
 * @author dhxstart
 * @date 2022/4/14 22:58
 */
public class NoticeViewModel extends MvvmBaseViewModel<INoticeView, NoticeModel<UserInfo>>
        implements IModelListener<String> {

    @Override
    protected void initModel() {
        model = new NoticeModel<>();
        model.register(this);
        model.getCacheDataAndLoad();
        model.load();
    }

    @Override
    public void onLoadFinish(BaseModel model, String token) {
        if (getPageView() == null) {
            return;
        }
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
