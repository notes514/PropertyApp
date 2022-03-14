package com.guet.home.adapter;

import android.view.View;

import androidx.databinding.DataBindingUtil;

import com.guet.home.R;
import com.guet.home.databinding.HomeItemBannerViewBinding;
import com.guet.home.nominate.bean.viewmodel.BannerCardViewModel;
import com.zhpan.bannerview.holder.ViewHolder;

/**
 * @author dhxstart
 * @date 2022/3/14 3:18
 */
public class BannerViewHolder implements ViewHolder<BannerCardViewModel> {

    @Override
    public int getLayoutId() {
        return R.layout.home_item_banner_view;
    }

    @Override
    public void onBind(View itemView, BannerCardViewModel data, int position, int size) {
        HomeItemBannerViewBinding binding = DataBindingUtil.bind(itemView);
        if (binding != null) {
            binding.setViewModel(data);
        }
    }
}
