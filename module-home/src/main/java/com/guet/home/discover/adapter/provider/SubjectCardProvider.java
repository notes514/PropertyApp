package com.guet.home.discover.adapter.provider;

import java.util.ArrayList;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.guet.common.contract.BaseCustomViewModel;
import com.guet.common.recyclerview.RecyclerItemDecoration;
import com.guet.common.utils.DensityUtils;
import com.guet.home.R;
import com.guet.home.databinding.HomeItemSubjectCardViewBinding;
import com.guet.home.discover.adapter.SubjectItemAdapter;
import com.guet.home.discover.bean.SquareCard;
import com.guet.home.discover.bean.SubjectCardBean;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;

/**
 * 应用模块:
 * <p>
 * 类描述:
 * <p>
 *
 * @author darryrzhoong
 * @since 2020-02-15
 */
public class SubjectCardProvider extends BaseItemProvider<BaseCustomViewModel> {
    @Override
    public int getItemViewType() {
        return IDisCoverItemType.SUBJECT_CARD_VIEW;
    }

    @Override
    public void onViewHolderCreated(@NotNull BaseViewHolder viewHolder,
                                    int viewType) {
        HomeItemSubjectCardViewBinding binding = DataBindingUtil.bind(viewHolder.itemView);

        binding.rvCategoryView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager =
                new GridLayoutManager(getContext(), 2);
        binding.rvCategoryView.setLayoutManager(gridLayoutManager);
        binding.rvCategoryView.addItemDecoration(new RecyclerItemDecoration(0,
                0, DensityUtils.dip2px(getContext(), 5), DensityUtils.dip2px(getContext(), 5)));
    }

    @Override
    public int getLayoutId() {
        return R.layout.home_item_subject_card_view;
    }

    @Override
    public void convert(@NotNull BaseViewHolder baseViewHolder,
                        @Nullable BaseCustomViewModel baseCustomViewModel) {
        if (baseCustomViewModel == null) {
            return;
        }
        HomeItemSubjectCardViewBinding binding = baseViewHolder.getBinding();
        if (binding != null) {
            SubjectCardBean cardBean = (SubjectCardBean) baseCustomViewModel;
            binding.tvTitle.setText(cardBean.getData().getHeader().getTitle());
            binding.tvActionTitle
                    .setText(cardBean.getData().getHeader().getRightText());
            ArrayList<SquareCard> dataList = new ArrayList<>();
            for (int i = 0; i < cardBean.getData().getItemList().size(); i++) {
                dataList.add(cardBean.getData().getItemList().get(i).getData());
            }
            SubjectItemAdapter adapter = new SubjectItemAdapter(
                    R.layout.home_item_category_item_subject_card_view);
            binding.rvCategoryView.setAdapter(adapter);
            adapter.setNewData(dataList);
        }
    }
}
