package com.guet.player.adapter.provider;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.guet.common.contract.BaseCustomViewModel;
import com.guet.player.R;
import com.guet.player.bean.viewmodel.VideoTextViewModel;
import com.guet.player.databinding.PlayerItemTitleWhiteViewBinding;

import androidx.databinding.DataBindingUtil;

/**
 * 应用模块:
 * <p>
 * 类描述:
 * <p>
 *
 * @author darryrzhoong
 * @since 2020-02-21
 */
public class TitleViewProvider extends BaseItemProvider<BaseCustomViewModel>
{
    @Override
    public int getItemViewType()
    {
        return IVideoItemType.TITLE_VIEW;
    }
    
    @Override
    public int getLayoutId()
    {
        return R.layout.player_item_title_white_view;
    }
    
    @Override
    public void onViewHolderCreated(@NotNull BaseViewHolder viewHolder,
        int viewType)
    {
        DataBindingUtil.bind(viewHolder.itemView);
    }
    
    @Override
    public void convert(@NotNull BaseViewHolder baseViewHolder,
        @Nullable BaseCustomViewModel baseCustomViewModel)
    {
        if (baseCustomViewModel == null)
        {
            return;
        }
        PlayerItemTitleWhiteViewBinding binding = baseViewHolder.getBinding();
        if (binding != null)
        {
            binding.setViewModel((VideoTextViewModel)baseCustomViewModel);
            binding.executePendingBindings();
        }
    }
}
