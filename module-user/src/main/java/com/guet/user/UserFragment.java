package com.guet.user;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.guet.base.fragment.MvvmBaseFragment;
import com.guet.base.viewmodel.IMvvmBaseViewModel;
import com.guet.common.router.RouterFragmentPath;
import com.guet.user.adapter.RecyclerAdapter;
import com.guet.user.databinding.UserFragmentLayoutBinding;
import com.guet.user.login.LoginActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 应用模块: 用户模块
 * <p>
 * 类描述:
 * <p>
 *
 * @author darryrzhoong
 * @since 2020-02-28
 */
@Route(path = RouterFragmentPath.User.PAGER_USER)
public class UserFragment extends MvvmBaseFragment<UserFragmentLayoutBinding, IMvvmBaseViewModel> {

    private RecyclerAdapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.user_fragment_layout;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initData();
    }

    private void initData() {
        List<String> items = new ArrayList<>();
        items.add("我的关注");
        items.add("我的收藏");
        items.add("视频功能声明");
        items.add("用户协议");
        items.add("版权声明");
        items.add("关于作者");
        adapter.setNewData(items);
    }

    private void initView() {
        if (getActivity() == null) {
            return;
        }
        Glide.with(getActivity()).load(getContext().getDrawable(R.drawable.avatar))
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(viewDataBinding.ivAvatar);
        viewDataBinding.rvTables.setHasFixedSize(true);
        viewDataBinding.rvTables
                .setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new RecyclerAdapter();
        adapter.setFooterView(getFooterView());
        viewDataBinding.rvTables.setAdapter(adapter);
        viewDataBinding.ivMore.setOnClickListener(v -> {
            LoginActivity.startAction(getActivity());
        });
        viewDataBinding.tvLike.setOnClickListener(v -> {
            LoginActivity.startAction(getActivity());
        });
        viewDataBinding.tvReply.setOnClickListener(v -> {
            LoginActivity.startAction(getActivity());
        });
        viewDataBinding.ivAvatar.setOnClickListener(v -> {
            LoginActivity.startAction(getActivity());
        });
    }

    private View getFooterView() {
        return LayoutInflater.from(getContext())
                .inflate(R.layout.user_item_footer_view, viewDataBinding.rvTables, false);
    }

    @Override
    public int getBindingVariable() {
        return 0;
    }

    @Override
    protected IMvvmBaseViewModel getViewModel() {
        return null;
    }

    @Override
    protected void onRetryBtnClick() {

    }
}
