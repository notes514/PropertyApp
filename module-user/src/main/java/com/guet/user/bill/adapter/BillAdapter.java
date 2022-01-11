package com.guet.user.bill.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.guet.common.contract.BaseCustomViewModel;
import com.guet.user.bill.bean.BillCustomViewModel;
import com.guet.user.databinding.UserItemBillViewBinding;
import com.guet.user.databinding.UserItemTradeViewBinding;
import com.guet.user.repair.bean.RepairCustomViewModel;

/**
 * @author dhxstart
 * @date 2022/1/9 17:36
 */
public class BillAdapter extends BaseQuickAdapter<BaseCustomViewModel, BaseViewHolder> {

    public BillAdapter(int layoutResId) {
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
        UserItemBillViewBinding binding = baseViewHolder.getBinding();
        if (binding != null) {
            binding.setViewModel((BillCustomViewModel) baseCustomViewModel);
            binding.executePendingBindings();
        }
    }
}
