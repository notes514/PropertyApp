package com.guet.community.supply;

import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.ToastUtils;
import com.guet.base.fragment.MvvmLazyFragment;
import com.guet.common.contract.BaseCustomViewModel;
import com.guet.common.recyclerview.RecyclerItemDecoration;
import com.guet.common.router.RouterActivityPath;
import com.guet.common.utils.DensityUtils;
import com.guet.community.R;
import com.guet.community.databinding.CommunityFragmentAttentionBinding;
import com.guet.community.supply.adapter.SupplyRecyclerAdapter;
import com.scwang.smart.refresh.footer.ClassicsFooter;
import com.scwang.smart.refresh.header.ClassicsHeader;

import java.util.ArrayList;

/**
 * @author dhxstart
 * @date 2022/4/17 15:32
 */
public class SupplyFragment extends MvvmLazyFragment<CommunityFragmentAttentionBinding, SupplyViewModel>
        implements ISupplyionView {
    private SupplyRecyclerAdapter adapter;

    public static SupplyFragment newInstance() {
        return new SupplyFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.community_fragment_attention;
    }

    @Override
    protected void onFragmentFirstVisible() {
        super.onFragmentFirstVisible();
        initView();
    }

    private void initView() {
        viewDataBinding.rvAttentionView.setHasFixedSize(true);

        if (getContext() == null) {
            return;
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        viewDataBinding.rvAttentionView.setLayoutManager(linearLayoutManager);
        adapter = new SupplyRecyclerAdapter(R.layout.community_item_supply_view);
        int decoration = DensityUtils.dp2px(getContext(), 10);
        viewDataBinding.rvAttentionView.addItemDecoration(
                new RecyclerItemDecoration(decoration, 0, decoration, decoration));
        viewDataBinding.rvAttentionView.setAdapter(adapter);

        //上拉刷新 & 下拉加载
        viewDataBinding.refreshLayout.setRefreshHeader(new ClassicsHeader(getContext()));
        viewDataBinding.refreshLayout.setRefreshFooter(new ClassicsFooter(getContext()));
        viewDataBinding.refreshLayout.setOnRefreshListener(refreshLayout -> {
            viewModel.tryRefresh();
        });
        viewDataBinding.refreshLayout.setOnLoadMoreListener(refreshLayout -> {
            viewModel.loadMore();
        });
        setLoadSir(viewDataBinding.refreshLayout);
        showLoading();
        viewModel.initModel();

        viewDataBinding.fabAdd.setOnClickListener( v -> {
            ARouter.getInstance().build(RouterActivityPath.Community.PAGE_ADD_SUPPLY).navigation();
        });
    }

    @Override
    public int getBindingVariable() {
        return 0;
    }

    @Override
    protected SupplyViewModel getViewModel() {
        return ViewModelProviders.of(this).get(SupplyViewModel.class);
    }

    @Override
    protected void onRetryBtnClick() {

    }

    @Override
    public void onLoadMoreFailure(String message) {
        viewDataBinding.refreshLayout.finishLoadMore(false);
    }

    @Override
    public void onLoadMoreEmpty() {
        viewDataBinding.refreshLayout.finishLoadMoreWithNoMoreData();
    }

    @Override
    public void onDataLoadFinish(ArrayList<BaseCustomViewModel> viewModels, boolean isFirstPage) {
        if (isFirstPage) {
            adapter.setNewData(viewModels);
            showContent();
            viewDataBinding.refreshLayout.finishRefresh(true);
        } else {
            adapter.addData(viewModels);
            showContent();
            viewDataBinding.refreshLayout.finishLoadMore(true);
        }
    }
}
