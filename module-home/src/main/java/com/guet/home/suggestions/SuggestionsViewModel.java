package com.guet.home.suggestions;

import com.guet.base.model.BaseModel;
import com.guet.base.model.IModelListener;
import com.guet.base.viewmodel.MvvmBaseViewModel;
import com.guet.common.contract.UserInfo;
import com.guet.home.suggestions.bean.SuggestionsCustomViewModel;

/**
 *
 *
 * @author dhxstart
 * @date 2022/4/14 22:58
 */
public class SuggestionsViewModel extends MvvmBaseViewModel<ISuggestionsView, SuggestionsModel<UserInfo>>
        implements IModelListener<Integer> {

    @Override
    protected void initModel() {
        model = new SuggestionsModel<>();
        model.register(this);
        model.getCacheDataAndLoad();
        model.load();
    }

    protected void insert(SuggestionsCustomViewModel viewModel) {
        model.insert(viewModel);
    }

    @Override
    public void onLoadFinish(BaseModel model, Integer code) {
        if (getPageView() == null) {
            return;
        }
        getPageView().onSuccess();
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
