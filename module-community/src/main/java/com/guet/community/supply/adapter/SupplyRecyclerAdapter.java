package com.guet.community.supply.adapter;

import android.annotation.SuppressLint;

import androidx.databinding.DataBindingUtil;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.guet.common.contract.BaseCustomViewModel;
import com.guet.community.databinding.CommunityItemSupplyViewBinding;
import com.guet.community.supply.bean.SupplyCustomViewModel;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 *
 *
 * @author dhxstart
 * @date 2022/4/17 15:31
 */
public class SupplyRecyclerAdapter extends BaseQuickAdapter<BaseCustomViewModel, BaseViewHolder> {

    public SupplyRecyclerAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void onItemViewHolderCreated(@NotNull BaseViewHolder viewHolder,
                                           int viewType) {
        DataBindingUtil.bind(viewHolder.itemView);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder,
                           @Nullable BaseCustomViewModel baseCustomViewModel) {
        if (baseCustomViewModel == null) {
            return;
        }
        CommunityItemSupplyViewBinding binding = baseViewHolder.getBinding();
        if (binding != null) {
            binding.setViewModel((SupplyCustomViewModel) baseCustomViewModel);
            binding.executePendingBindings();
        }
    }
}
