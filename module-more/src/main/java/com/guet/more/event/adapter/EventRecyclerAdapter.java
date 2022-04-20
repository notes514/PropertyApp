package com.guet.more.event.adapter;

import android.annotation.SuppressLint;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;

import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.LogUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.guet.common.contract.BaseCustomViewModel;
import com.guet.common.router.RouterActivityPath;
import com.guet.more.databinding.MoreItemSupplyViewBinding;
import com.guet.more.event.bean.EventCustomViewModel;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

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
        MoreItemSupplyViewBinding binding = baseViewHolder.getBinding();
        if (binding != null) {
            binding.setViewModel((EventCustomViewModel) baseCustomViewModel);
            binding.executePendingBindings();
        }
    }

    //
//    @Override
//    public void onClick(@NonNull BaseViewHolder helper, @NonNull View view,
//                        BaseCustomViewModel data, int position) {
//        if (data == null) {
//            return;
//        }
//        NoticeViewModel noticeViewModel = (NoticeViewModel) data;
////        NoticeBean noticeBean = new NoticeBean();
////        noticeBean.setId(model.id);
////        noticeBean.setTitle(model.title);
////        noticeBean.setContent(model.content);
////        noticeBean.setReleaseTime(model.releaseTime);
////        noticeBean.setImageUrl(model.imageUrl);
//
//        ARouter.getInstance()
//                .build(RouterActivityPath.Home.PAGE_NOTICE)
//                .withParcelable("noticeViewModel", noticeViewModel)
//                .navigation();
//    }
}
