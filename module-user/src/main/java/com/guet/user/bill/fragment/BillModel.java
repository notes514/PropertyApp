package com.guet.user.bill.fragment;

import com.guet.base.model.BasePagingModel;
import com.guet.user.bill.bean.BillCustomViewModel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * RepairModel
 *
 * @author dhxstart
 * @date 2022/1/9 19:41
 */
public class BillModel<T> extends BasePagingModel<T> {
    private final int position;

    public BillModel(int position) {
        this.position = position;
    }

    @Override
    protected void load() {
        List<BillCustomViewModel> viewModels = new ArrayList<>();
        BillCustomViewModel viewModel = new BillCustomViewModel();
        for (int i = 0; i < 10; i++) {
            if (position == 0) {
                viewModel.chargeName = "物业费 -> 全部" + i;
                viewModel.chargeStandard = "￥" + 100;
                viewModel.gmtCreate = "2022年1月9日";
            } else if (position == 1) {
                viewModel.chargeName = "物业费 -> 未缴费" + i;
                viewModel.chargeStandard = "￥" + 100;
                viewModel.gmtCreate = "2022年1月9日";
            } else {
                viewModel.chargeName = "物业费 -> 已缴费" + i;
                viewModel.chargeStandard = "￥" + 100;
                viewModel.gmtCreate = "时间：2022年1月9日";
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
