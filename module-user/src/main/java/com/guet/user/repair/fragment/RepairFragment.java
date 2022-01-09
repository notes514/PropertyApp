package com.guet.user.repair.fragment;

import android.os.Bundle;

import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.guet.base.fragment.MvvmLazyFragment;
import com.guet.common.contract.BaseCustomViewModel;
import com.guet.common.databinding.CommonFragmentListBinding;
import com.guet.common.recyclerview.RecyclerItemDecoration;
import com.guet.common.router.RouterFragmentPath;
import com.guet.common.utils.DensityUtils;
import com.guet.user.R;
import com.guet.user.repair.adapter.RepairAdapter;
import com.scwang.smart.refresh.footer.ClassicsFooter;
import com.scwang.smart.refresh.header.ClassicsHeader;

import java.util.ArrayList;

/**
 * RepairFragment
 *
 * @author dhxstart
 * @date 2022/1/8 22:12
 */
public class RepairFragment extends MvvmLazyFragment<CommonFragmentListBinding, RepairViewModel>
        implements IRepairView {
    private int position;
    private RepairAdapter mAdapter;

    public static RepairFragment newInstance(int position) {
        RepairFragment fragment = new RepairFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.common_fragment_list;
    }

    @Override
    protected void onFragmentFirstVisible() {
        super.onFragmentFirstVisible();
        initView();
    }

    @Override
    protected void initParameters() {
        if (getArguments() != null) {
            position = getArguments().getInt("position");
        }
    }

    /** 初始化view */
    private void initView() {
        if (getContext() == null) {
            return;
        }
        mAdapter = new RepairAdapter(R.layout.user_item_repair_view);
        viewDataBinding.commonRecycler.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        viewDataBinding.commonRecycler.setLayoutManager(layoutManager);
        viewDataBinding.commonRecycler.setAdapter(mAdapter);

        viewDataBinding.commonRefresh.setRefreshHeader(new ClassicsHeader(getContext()));
        viewDataBinding.commonRefresh.setRefreshFooter(new ClassicsFooter(getContext()));
        viewDataBinding.commonRefresh.setOnRefreshListener(refreshLayout -> {
            viewModel.tryRefresh();
        });
        viewDataBinding.commonRefresh.setOnLoadMoreListener(refreshLayout -> {
            viewModel.loadMore();
        });
        setLoadSir(viewDataBinding.commonRefresh);
        showLoading();
        viewModel.initModel(position);
    }

    @Override
    public int getBindingVariable() {
        return 0;
    }

    @Override
    protected RepairViewModel getViewModel() {
        return ViewModelProviders.of(this).get(RepairViewModel.class);
    }

    @Override
    protected void onRetryBtnClick() {

    }

    @Override
    public void onLoadMoreFailure(String message) {
        viewDataBinding.commonRefresh.finishLoadMore(false);
    }

    @Override
    public void onLoadMoreEmpty() {
        viewDataBinding.commonRefresh.finishLoadMoreWithNoMoreData();
    }

    @Override
    public void onDataLoadFinish(ArrayList<BaseCustomViewModel> viewModels, boolean isFirstPage) {
        if (viewModels == null) {
            return;
        }
        if (isFirstPage) {
            mAdapter.setNewData(viewModels);
        } else {
            mAdapter.addData(viewModels);
        }
        showContent();
        viewDataBinding.commonRefresh.finishRefresh(true);
    }
}
