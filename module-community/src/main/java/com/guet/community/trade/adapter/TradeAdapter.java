package com.guet.community.trade.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.guet.common.contract.BaseCustomViewModel;
import com.guet.community.databinding.CommunityItemTradeViewBinding;
import com.guet.community.trade.bean.TradeCustomViewModel;

/**
 * @author dhxstart
 * @date 2022/1/9 17:36
 */
public class TradeAdapter extends BaseQuickAdapter<BaseCustomViewModel, BaseViewHolder> {

    public TradeAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void onItemViewHolderCreated(@NonNull BaseViewHolder viewHolder, int viewType) {
        DataBindingUtil.bind(viewHolder.itemView);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder baseViewHolder,
                           @Nullable BaseCustomViewModel baseCustomViewModel) {
        if (baseCustomViewModel == null) {
            return;
        }
        CommunityItemTradeViewBinding binding = baseViewHolder.getBinding();
        if (binding != null) {
            binding.setViewModel((TradeCustomViewModel) baseCustomViewModel);
            binding.executePendingBindings();
        }
    }
}
