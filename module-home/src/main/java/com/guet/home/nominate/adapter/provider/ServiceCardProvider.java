package com.guet.home.nominate.adapter.provider;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.guet.common.contract.BaseCustomViewModel;

/**
 * 服务类别卡片
 *
 * @author dhxstart
 * @date 2022/4/5 23:33
 */
public class ServiceCardProvider extends BaseItemProvider<BaseCustomViewModel> {

    @Override
    public int getItemViewType() {
        return NominateItemType.FOLLOW_CARD_VIEW;
    }

    @Override
    public int getLayoutId() {
        return 0;
    }

    @Override
    public void convert(@NonNull BaseViewHolder baseViewHolder, @Nullable BaseCustomViewModel baseCustomViewModel) {

    }
}
