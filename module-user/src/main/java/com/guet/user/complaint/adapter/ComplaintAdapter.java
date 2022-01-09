package com.guet.user.complaint.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.guet.common.contract.BaseCustomViewModel;
import com.guet.user.complaint.bean.ComplaintCustomViewModel;
import com.guet.user.databinding.UserItemComplaintViewBinding;
import com.guet.user.databinding.UserItemTradeViewBinding;
import com.guet.user.trade.bean.TradeCustomViewModel;

/**
 *
 * @author dhxstart
 * @date 2022/1/9 17:36
 */
public class ComplaintAdapter extends BaseQuickAdapter<BaseCustomViewModel, BaseViewHolder> {

    public ComplaintAdapter(int layoutResId) {
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
        UserItemComplaintViewBinding binding = baseViewHolder.getBinding();
        if (binding != null) {
            binding.setViewModel((ComplaintCustomViewModel) baseCustomViewModel);
            binding.executePendingBindings();
        }
    }
}
