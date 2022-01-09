package com.guet.user.complaint.fragment;

import com.guet.base.model.BasePagingModel;
import com.guet.user.complaint.bean.ComplaintCustomViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * RepairModel
 *
 * @author dhxstart
 * @date 2022/1/9 19:41
 */
public class ComplaintModel<T> extends BasePagingModel<T> {
    private final int position;

    public ComplaintModel(int position) {
        this.position = position;
    }

    @Override
    protected void load() {
        List<ComplaintCustomViewModel> viewModels = new ArrayList<>();
        ComplaintCustomViewModel viewModel = new ComplaintCustomViewModel();
        for (int i = 0; i < 10; i++) {
            if (position == 0) {
                viewModel.complaintType = "今天晚上一起开黑啊 -> 待受理 " + i;
                viewModel.complaintContent = "来一起打王者啊 -> 待受理" + i;
                viewModel.gmtModified = "2022年1月9日";
            } else if (position == 1) {
                viewModel.complaintType = "今天晚上一起开黑啊 -> 受理中 " + i;
                viewModel.complaintContent = "来一起打王者啊 -> 受理中 " + i;
                viewModel.gmtCreate = "2022年1月9日";
            } else {
                viewModel.complaintType = "今天晚上一起开黑啊 -> 已受理 " + i;
                viewModel.complaintContent = "来一起打王者啊 -> 已受理 " + i;
                viewModel.gmtCreate = "2022年1月9日";
            }
            viewModels.add(viewModel);
        }
        loadSuccess((T) viewModels, viewModels.size() == 0, isRefresh);
    }

    public void loadMore() {
        isRefresh = false;
        loadSuccess(null, true, isRefresh);
    }

    public void refresh() {
        isRefresh = true;
        load();
    }

    @Override
    public void cancel() {
        super.cancel();
    }
}
