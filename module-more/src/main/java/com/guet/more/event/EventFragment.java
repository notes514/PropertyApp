package com.guet.more.event;

import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.alibaba.android.arouter.launcher.ARouter;
import com.guet.base.fragment.MvvmLazyFragment;
import com.guet.common.contract.BaseCustomViewModel;
import com.guet.common.recyclerview.RecyclerItemDecoration;
import com.guet.common.router.RouterActivityPath;
import com.guet.common.utils.DensityUtils;
import com.guet.more.R;
import com.guet.more.databinding.MoreFragmentTopicBinding;
import com.guet.more.event.adapter.EventRecyclerAdapter;
import com.guet.more.event.bean.EventCustomViewModel;
import com.scwang.smart.refresh.footer.ClassicsFooter;
import com.scwang.smart.refresh.header.ClassicsHeader;

import java.util.ArrayList;

/**
 * @author dhxstart
 * @date 2022/4/17 15:32
 */
public class EventFragment extends MvvmLazyFragment<MoreFragmentTopicBinding, EventViewModel>
        implements IEventView {
    private EventRecyclerAdapter adapter;

    public static EventFragment newInstance() {
        return new EventFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.more_fragment_topic;
    }

    @Override
    protected void onFragmentFirstVisible() {
        super.onFragmentFirstVisible();
        initView();
    }

    private void initView() {
        viewDataBinding.rvTopicView.setHasFixedSize(true);

        if (getContext() == null) {
            return;
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        viewDataBinding.rvTopicView.setLayoutManager(linearLayoutManager);
        adapter = new EventRecyclerAdapter(R.layout.more_item_supply_view);
        int decoration = DensityUtils.dp2px(getContext(), 10);
        viewDataBinding.rvTopicView.addItemDecoration(
                new RecyclerItemDecoration(decoration, 0, decoration, decoration));
        viewDataBinding.rvTopicView.setAdapter(adapter);

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

        adapter.setOnItemClickListener((adapter, view, position) -> {
            EventCustomViewModel model = (EventCustomViewModel) adapter.getData().get(position);
            ARouter.getInstance()
                    .build(RouterActivityPath.More.PAGE_EVENT_DETAILS)
                    .withParcelable("eventCustomViewModel", model)
                    .navigation();
        });
    }

    @Override
    public int getBindingVariable() {
        return 0;
    }

    @Override
    protected EventViewModel getViewModel() {
        return ViewModelProviders.of(this).get(EventViewModel.class);
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
