package com.guet.home.discover.adapter;

import java.util.List;

import org.jetbrains.annotations.NotNull;

import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.guet.common.contract.BaseCustomViewModel;
import com.guet.home.discover.adapter.provider.CategoryCardProvider;
import com.guet.home.discover.adapter.provider.ContentBannerProvider;
import com.guet.home.discover.adapter.provider.IDisCoverItemType;
import com.guet.home.discover.adapter.provider.SubjectCardProvider;
import com.guet.home.discover.adapter.provider.ThemeProvider;
import com.guet.home.discover.adapter.provider.TitleProvider;
import com.guet.home.discover.adapter.provider.TopBannerProvider;
import com.guet.home.discover.adapter.provider.VideoCardProvider;
import com.guet.home.discover.bean.CategoryCardBean;
import com.guet.home.discover.bean.SubjectCardBean;
import com.guet.home.discover.bean.viewmodel.BriefCardViewModel;
import com.guet.home.discover.bean.viewmodel.ContentBannerViewModel;
import com.guet.home.discover.bean.viewmodel.TopBannerViewModel;
import com.guet.home.nominate.bean.viewmodel.TitleViewModel;
import com.guet.home.nominate.bean.viewmodel.VideoCardViewModel;


/**
 * 应用模块:
 * <p>
 * 类描述: 首页-发现 数据控制adapter
 * <p>
 *
 * @author darryrzhoong
 * @since 2020-02-15
 */
public class ProviderDisCoverAdapter
    extends BaseProviderMultiAdapter<BaseCustomViewModel>
{
    
    public ProviderDisCoverAdapter()
    {
        super();
        // 注册具体业务提供者
        addItemProvider(new TopBannerProvider());
        addItemProvider(new CategoryCardProvider());
        addItemProvider(new SubjectCardProvider());
        addItemProvider(new ContentBannerProvider());
        addItemProvider(new TitleProvider());
        addItemProvider(new VideoCardProvider());
        addItemProvider(new ThemeProvider());
        
    }
    
    @Override
    protected int getItemType(@NotNull List<? extends BaseCustomViewModel> data,
        int position)
    {
        if (data.get(position) instanceof TopBannerViewModel)
        {
            return IDisCoverItemType.TOP_BANNER_VIEW;
        }
        else if (data.get(position) instanceof CategoryCardBean)
        {
            return IDisCoverItemType.CATEGORY_CARD_VIEW;
        }
        else if (data.get(position) instanceof SubjectCardBean)
        {
            return IDisCoverItemType.SUBJECT_CARD_VIEW;
        }
        else if (data.get(position) instanceof TitleViewModel)
        {
            return IDisCoverItemType.TITLE_VIEW;
        }
        else if (data.get(position) instanceof ContentBannerViewModel)
        {
            return IDisCoverItemType.CONTENT_BANNER_VIEW;
        }
        else if (data.get(position) instanceof VideoCardViewModel)
        {
            return IDisCoverItemType.VIDEO_CARD_VIEW;
        }
        else if (data.get(position) instanceof BriefCardViewModel)
        {
            return IDisCoverItemType.THEME_CARD_VIEW;
        }
        return -1;
    }
    
}
