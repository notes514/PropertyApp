package com.guet.user.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.guet.common.contract.BaseCustomViewModel;
import com.guet.user.repair.bean.RepairCustomViewModel;

import java.util.List;

/**
 * @author dhxstart
 * @date 2022/1/8 21:38
 */
public class UserViewPagerAdapter extends BaseQuickAdapter<BaseCustomViewModel, BaseViewHolder> {

    public UserViewPagerAdapter(int layoutResId) {
        super(layoutResId);
    }

    public UserViewPagerAdapter(int layoutResId, @Nullable List<BaseCustomViewModel> data) {
        super(layoutResId, data);
    }

    @Override
    protected void onItemViewHolderCreated(@NonNull BaseViewHolder viewHolder, int viewType) {
        DataBindingUtil.bind(viewHolder.itemView);
        super.onItemViewHolderCreated(viewHolder, viewType);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder baseViewHolder,
                           @Nullable BaseCustomViewModel baseCustomViewModel) {
        if (baseCustomViewModel == null) {
            return;
        }
        ViewDataBinding binding = baseViewHolder.getBinding();
        if (binding == null) {
            return;
        }
        RepairCustomViewModel cardViewModel = (RepairCustomViewModel) baseCustomViewModel;

    }

    @Override
    protected int getDefItemCount() {
        return getData().isEmpty() ? 0 : getData().size();
    }
}
