package com.guet.user.trade.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.guet.common.contract.BaseCustomViewModel;
import com.guet.user.databinding.UserItemTradeViewBinding;
import com.guet.user.trade.bean.TradeCustomViewModel;

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
        UserItemTradeViewBinding binding = baseViewHolder.getBinding();
        if (binding == null) {
            return;
        }
        binding.setViewModel((TradeCustomViewModel) baseCustomViewModel);
        binding.executePendingBindings();
        TradeCustomViewModel customViewModel = (TradeCustomViewModel) baseCustomViewModel;
//        binding.itemProjectTop.setVisibility(customViewModel.version > 2 ? View.GONE : View.VISIBLE);
//        binding.itemProjectNew.setVisibility(customViewModel.version > 2 ? View.GONE : View.VISIBLE);
    }
}
