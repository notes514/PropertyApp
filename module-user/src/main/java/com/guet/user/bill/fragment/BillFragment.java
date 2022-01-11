package com.guet.user.bill.fragment;

import android.os.Bundle;

import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.guet.base.fragment.MvvmLazyFragment;
import com.guet.common.contract.BaseCustomViewModel;
import com.guet.common.databinding.CommonFragmentListBinding;
import com.guet.user.R;
import com.guet.user.bill.adapter.BillAdapter;
import com.scwang.smart.refresh.footer.ClassicsFooter;
import com.scwang.smart.refresh.header.ClassicsHeader;

import java.util.ArrayList;

/**
 * TradeFragment
 *
 * @author dhxstart
 * @date 2022/1/8 22:12
 */
public class BillFragment extends MvvmLazyFragment<CommonFragmentListBinding, BillViewModel>
        implements IBillView {
    private int position;
    private BillAdapter mAdapter;


    public static BillFragment newInstance(int position) {
        BillFragment fragment = new BillFragment();
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
        mAdapter = new BillAdapter(R.layout.user_item_bill_view);
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
    protected BillViewModel getViewModel() {
        return ViewModelProviders.of(this).get(BillViewModel.class);
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
