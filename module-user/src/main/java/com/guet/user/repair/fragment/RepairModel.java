package com.guet.user.repair.fragment;

import com.guet.base.model.BasePagingModel;
import com.guet.common.contract.BaseCustomViewModel;
import com.guet.user.repair.bean.RepairCustomViewModel;

import java.util.ArrayList;

/**
 * RepairModel
 *
 * @author dhxstart
 * @date 2022/1/9 19:41
 */
public class RepairModel<T> extends BasePagingModel<T> {
    private final int position;

    public RepairModel(int position) {
        this.position = position;
    }

    @Override
    protected void load() {
        ArrayList<BaseCustomViewModel> viewModels = new ArrayList<>();
        RepairCustomViewModel repairBean = new RepairCustomViewModel();
        for (int i = 0; i < 10; i++) {
            if (position == 0) {
                repairBean.repairType = "今天晚上一起开黑啊 -> 待受理 " + i;
                repairBean.repairContent = "来一起打王者啊 -> 待受理" + i;
                repairBean.gmtCreate = "2022年1月9日";
            } else if (position == 1) {
                repairBean.repairType = "今天晚上一起开黑啊 -> 受理中 " + i;
                repairBean.repairContent = "来一起打王者啊 -> 受理中 " + i;
                repairBean.gmtCreate = "2022年1月9日";
            } else {
                repairBean.repairType = "今天晚上一起开黑啊 -> 已受理 " + i;
                repairBean.repairContent = "来一起打王者啊 -> 已受理 " + i;
                repairBean.gmtCreate = "2022年1月9日";
            }
            viewModels.add(repairBean);
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
