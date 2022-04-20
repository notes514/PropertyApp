package com.guet.more.notice.adapter;

import android.annotation.SuppressLint;

import androidx.databinding.DataBindingUtil;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.guet.common.contract.BaseCustomViewModel;
import com.guet.more.databinding.MoreItemNoticeViewBinding;
import com.guet.more.databinding.MoreItemSupplyViewBinding;
import com.guet.more.notice.bean.NoticeCustomViewModel;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 *
 *
 * @author dhxstart
 * @date 2022/4/17 15:31
 */
public class EventRecyclerAdapter extends BaseQuickAdapter<BaseCustomViewModel, BaseViewHolder> {

    public EventRecyclerAdapter(int layoutResId) {
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
        MoreItemNoticeViewBinding binding = baseViewHolder.getBinding();
        if (binding != null) {
            binding.setViewModel((NoticeCustomViewModel) baseCustomViewModel);
            binding.executePendingBindings();
        }
    }
}
