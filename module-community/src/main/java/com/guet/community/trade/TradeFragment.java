package com.guet.community.trade;

import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.guet.base.fragment.MvvmLazyFragment;
import com.guet.common.contract.BaseCustomViewModel;
import com.guet.common.databinding.CommonFragmentListBinding;
import com.guet.community.R;
import com.guet.community.trade.adapter.TradeAdapter;
import com.scwang.smart.refresh.footer.ClassicsFooter;
import com.scwang.smart.refresh.header.ClassicsHeader;

import java.util.List;

/**
 * TradeFragment
 *
 * @author dhxstart
 * @date 2022/1/8 22:12
 */
public class TradeFragment extends MvvmLazyFragment<CommonFragmentListBinding, TradeViewModel>
        implements ITradeView {
    private TradeAdapter mAdapter;

    public static TradeFragment newInstance() {
        return new TradeFragment();
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

    /** 初始化view */
    private void initView() {
        if (getContext() == null) {
            return;
        }
        mAdapter = new TradeAdapter(R.layout.community_item_trade_view);
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
        viewModel.initModel();
    }

    @Override
    public int getBindingVariable() {
        return 0;
    }

    @Override
    protected TradeViewModel getViewModel() {
        return ViewModelProviders.of(this).get(TradeViewModel.class);
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
    public void onDataLoadFinish(List<BaseCustomViewModel> viewModels, boolean isFirstPage) {
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
