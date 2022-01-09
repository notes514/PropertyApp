package com.guet.user.trade.fragment;

import com.guet.base.model.BasePagingModel;
import com.guet.common.contract.BaseCustomViewModel;
import com.guet.user.repair.bean.RepairCustomViewModel;
import com.guet.user.trade.bean.TradeCustomViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * RepairModel
 *
 * @author dhxstart
 * @date 2022/1/9 19:41
 */
public class TradeModel<T> extends BasePagingModel<T> {
    private final int position;

    public TradeModel(int position) {
        this.position = position;
    }

    @Override
    protected void load() {
        List<TradeCustomViewModel> viewModels = new ArrayList<>();
        TradeCustomViewModel viewModel = new TradeCustomViewModel();
        for (int i = 0; i < 10; i++) {
            if (position == 0) {
                viewModel.ownerName = "代小飞";
                viewModel.title = "从老家带来精心酿制的白酒 -> " + i;
                viewModel.address = "西海岸小区东区大门旁边 -> 未开始";
                viewModel.imageUrl = "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F2020-06-19%2F5eec6828e7880.jpg&refer=http%3A%2F%2Fpic1.win4000.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1644322984&t=c22add22c2a7db042fe568f7063f15f1";
                viewModel.gmtCreate = "2022年1月9日";
            } else if (position == 1) {
                viewModel.ownerName = "代小飞";
                viewModel.title = "从老家带来精心酿制的白酒 -> " + i;
                viewModel.address = "西海岸小区东区大门旁边 -> 进行中";
                viewModel.imageUrl = "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F2020-06-19%2F5eec6828e7880.jpg&refer=http%3A%2F%2Fpic1.win4000.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1644322984&t=c22add22c2a7db042fe568f7063f15f1";
                viewModel.gmtCreate = "2022年1月9日";
            } else {
                viewModel.ownerName = "代小飞";
                viewModel.title = "从老家带来精心酿制的白酒 -> " + i;
                viewModel.address = "西海岸小区东区大门旁边 -> 已结束";
                viewModel.imageUrl = "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F2020-06-19%2F5eec6828e7880.jpg&refer=http%3A%2F%2Fpic1.win4000.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1644322984&t=c22add22c2a7db042fe568f7063f15f1";
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
