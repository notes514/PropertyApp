package com.guet.home.discover.adapter.provider;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.guet.common.contract.BaseCustomViewModel;
import com.guet.common.contract.VideoHeaderBean;
import com.guet.common.router.RouterActivityPath;
import com.guet.home.R;
import com.guet.home.databinding.HomeItemVideoCardViewBinding;
import com.guet.home.nominate.bean.viewmodel.VideoCardViewModel;

import androidx.databinding.DataBindingUtil;

/**
 * 应用模块:
 * <p>
 * 类描述:
 * <p>
 *
 * @author darryrzhoong
 * @since 2020-02-15
 */
public class VideoCardProvider extends BaseItemProvider<BaseCustomViewModel> {
    @Override
    public int getItemViewType() {
        return IDisCoverItemType.VIDEO_CARD_VIEW;
    }

    @Override
    public int getLayoutId() {
        return R.layout.home_item_video_card_view;
    }

    @Override
    public void onViewHolderCreated(@NotNull BaseViewHolder viewHolder, int viewType) {
        DataBindingUtil.bind(viewHolder.itemView);
    }

    @Override
    public void convert(@NotNull BaseViewHolder baseViewHolder,
                        @Nullable BaseCustomViewModel baseCustomViewModel) {
        HomeItemVideoCardViewBinding binding =
                baseCustomViewModel != null ? baseViewHolder.getBinding() : null;
        if (binding == null) {
            return;
        }
        VideoCardViewModel cardViewModel =
                (VideoCardViewModel) baseCustomViewModel;
        binding.ivVideoCover.setOnClickListener(v -> {
            VideoHeaderBean headerBean = new VideoHeaderBean(
                    cardViewModel.title, cardViewModel.description,
                    cardViewModel.video_description,
                    cardViewModel.collectionCount, cardViewModel.shareCount,
                    cardViewModel.authorUrl, cardViewModel.nickName,
                    cardViewModel.userDescription, cardViewModel.playerUrl,
                    cardViewModel.blurredUrl, cardViewModel.videoId);
            ARouter.getInstance()
                    .build(RouterActivityPath.Video.PAGER_VIDEO)
                    .withParcelable("videoInfo", headerBean)
                    .navigation();
        });
        binding.setViewModel(cardViewModel);
        binding.executePendingBindings();
    }
}
