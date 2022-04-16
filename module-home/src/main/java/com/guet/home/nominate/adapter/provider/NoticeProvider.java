package com.guet.home.nominate.adapter.provider;

import android.os.Parcelable;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.LogUtils;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.guet.base.utils.ToastUtil;
import com.guet.common.contract.BaseCustomViewModel;
import com.guet.common.router.RouterActivityPath;
import com.guet.home.R;
import com.guet.home.databinding.HomeItemNoticeViewBinding;
import com.guet.home.databinding.HomeItemTitleLeftRightViewBinding;
import com.guet.home.nominate.bean.NoticeBean;
import com.guet.home.nominate.bean.viewmodel.NoticeViewModel;
import com.guet.home.nominate.bean.viewmodel.TitleViewModel;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 应用模块:
 * <p>
 * 类描述:
 * <p>
 *
 * @author darryrzhoong
 * @since 2020-02-14
 */
public class NoticeProvider extends BaseItemProvider<BaseCustomViewModel> {
    @Override
    public int getItemViewType() {
        return NominateItemType.TITLE_VIEW;
    }

    @Override
    public int getLayoutId() {
        return R.layout.home_item_notice_view;
    }

    @Override
    public void onViewHolderCreated(BaseViewHolder viewHolder, int viewType) {
        DataBindingUtil.bind(viewHolder.itemView);
    }

    @Override
    public void convert(@NotNull BaseViewHolder baseViewHolder,
                        @Nullable BaseCustomViewModel baseCustomViewModel) {
        if (baseCustomViewModel == null) {
            return;
        }
        HomeItemNoticeViewBinding binding = baseViewHolder.getBinding();
        if (binding != null) {
            binding.setViewModel((NoticeViewModel) baseCustomViewModel);
        }
    }

    @Override
    public void onClick(@NonNull BaseViewHolder helper, @NonNull View view,
                        BaseCustomViewModel data, int position) {
        if (data == null) {
            return;
        }
        NoticeViewModel noticeViewModel = (NoticeViewModel) data;
//        NoticeBean noticeBean = new NoticeBean();
//        noticeBean.setId(model.id);
//        noticeBean.setTitle(model.title);
//        noticeBean.setContent(model.content);
//        noticeBean.setReleaseTime(model.releaseTime);
//        noticeBean.setImageUrl(model.imageUrl);

        ARouter.getInstance()
                .build(RouterActivityPath.Home.PAGE_NOTICE)
                .withParcelable("noticeViewModel", noticeViewModel)
                .navigation();
    }
}
