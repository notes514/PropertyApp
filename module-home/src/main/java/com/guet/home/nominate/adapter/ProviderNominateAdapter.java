package com.guet.home.nominate.adapter;

import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.guet.common.contract.BaseCustomViewModel;
import com.guet.home.nominate.adapter.provider.FollowCardProvider;
import com.guet.home.nominate.adapter.provider.NominateItemType;
import com.guet.home.nominate.adapter.provider.NoticeProvider;
import com.guet.home.nominate.adapter.provider.SingleTitleProvider;
import com.guet.home.nominate.adapter.provider.TitleProvider;
import com.guet.home.nominate.adapter.provider.VideoCardProvider;
import com.guet.home.nominate.bean.viewmodel.FollowCardViewModel;
import com.guet.home.nominate.bean.viewmodel.NoticeViewModel;
import com.guet.home.nominate.bean.viewmodel.SingleTitleViewModel;
import com.guet.home.nominate.bean.viewmodel.TitleViewModel;
import com.guet.home.nominate.bean.viewmodel.VideoCardViewModel;

import java.util.List;

import org.jetbrains.annotations.NotNull;


/**
 * 应用模块:
 * <p>
 * 类描述:
 * <p>
 *
 * @author darryrzhoong
 * @since 2020-02-14
 */
public class ProviderNominateAdapter extends BaseProviderMultiAdapter<BaseCustomViewModel> {

    public ProviderNominateAdapter() {
        super();
        // 注册Provide
        addItemProvider(new NoticeProvider());
//        addItemProvider(new FollowCardProvider());
//        addItemProvider(new SingleTitleProvider());
//        addItemProvider(new VideoCardProvider());
    }

    @Override
    protected int getItemType(@NotNull List<? extends BaseCustomViewModel> data, int position) {
        if (data.get(position) instanceof NoticeViewModel) {
            return NominateItemType.TITLE_VIEW;
        }
        return -1;
    }
}
