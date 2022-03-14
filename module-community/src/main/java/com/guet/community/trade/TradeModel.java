package com.guet.community.trade;

import com.guet.base.model.BasePagingModel;
import com.guet.community.trade.bean.TradeCustomViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * RepairModel
 *
 * @author dhxstart
 * @date 2022/1/9 19:41
 */
public class TradeModel<T> extends BasePagingModel<T> {

    @Override
    protected void load() {
        List<TradeCustomViewModel> viewModels = new ArrayList<>();
        TradeCustomViewModel viewModel = new TradeCustomViewModel();
        for (int i = 0; i < 5; i++) {
            if (i == 0) {
                viewModel.ownerName = "代小飞";
                viewModel.avatar = "https://img0.baidu.com/it/u=164232245,2005229505&fm=253&fmt=auto&app=138&f=JPEG?w=400&h=400";
                viewModel.title = "从老家带来精心酿制的白酒 -> " + i;
                viewModel.address = "西海岸小区东区大门旁边 -> 未开始";
                viewModel.imageUrl = "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F2020-06-19%2F5eec6828e7880.jpg&refer=http%3A%2F%2Fpic1.win4000.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1644322984&t=c22add22c2a7db042fe568f7063f15f1";
                viewModel.gmtCreate = "2022年1月9日";
            } else if (i == 1) {
                viewModel.ownerName = "代小飞";
                viewModel.avatar = "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fup.enterdesk.com%2Fedpic%2F80%2F5a%2Fd4%2F805ad49d1a4bc025cae4057104b70945.jpg&refer=http%3A%2F%2Fup.enterdesk.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1649831803&t=f488ff9c35673e07c436f6b08291bd3c";
                viewModel.title = "从老家带来精心酿制的白酒 -> " + i;
                viewModel.address = "西海岸小区东区大门旁边 -> 进行中";
                viewModel.imageUrl = "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F2020-06-19%2F5eec6828e7880.jpg&refer=http%3A%2F%2Fpic1.win4000.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1644322984&t=c22add22c2a7db042fe568f7063f15f1";
                viewModel.gmtCreate = "2022年1月9日";
            } else {
                viewModel.ownerName = "代小飞";
                viewModel.avatar = "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fup.enterdesk.com%2Fedpic%2F4d%2F63%2Fbd%2F4d63bd0b3bf8cc9aa0dc3e1111646b1c.jpeg&refer=http%3A%2F%2Fup.enterdesk.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1649831803&t=9195c463a04d7e724b3f79c75c74a801";
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
        loadSuccess(null, true, false);
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
