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
        repairBean.repairType = "公共区域";
        repairBean.repairContent = "小区9栋3楼楼道漏水";
        repairBean.gmtCreate = "2021-12-30 21:39:03";

        RepairCustomViewModel repairBean1 = new RepairCustomViewModel();
        repairBean1.repairType = "公共区域";
        repairBean1.repairContent = "小区东侧公路有挖坑";
        repairBean1.gmtCreate = "2021-12-30 21:41:56";

        RepairCustomViewModel repairBean2 = new RepairCustomViewModel();
        repairBean2.repairType = "卫生间";
        repairBean2.repairContent = "小区6-202房为卫生间洗衣机损坏";
        repairBean2.gmtCreate = "2021-12-30 21:45:36";

        RepairCustomViewModel repairBean3 = new RepairCustomViewModel();
        repairBean3.repairType = "公共区域";
        repairBean3.repairContent = "小区9栋3楼楼道漏水";
        repairBean3.gmtCreate = "2021-12-30 21:39:03";

        viewModels.add(repairBean);
        viewModels.add(repairBean1);
        viewModels.add(repairBean2);
        viewModels.add(repairBean3);
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
