package com.guet.home.suggestions;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.lifecycle.ViewModelProviders;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.guet.base.activity.MvvmBaseActivity;
import com.guet.common.adapter.ScreenAutoAdapter;
import com.guet.common.router.RouterActivityPath;
import com.guet.common.utils.TitleBarUtils;
import com.guet.home.R;
import com.guet.home.databinding.HomeActivitySuggestionsBinding;
import com.guet.home.suggestions.bean.SuggestionsCustomViewModel;

/**
 *
 *
 * @author dhxstart
 * @date 2022/4/14 22:56
 */
@Route(path = RouterActivityPath.Home.PAGE_SUGGESTIONS)
public class SuggestionsActivity extends MvvmBaseActivity<HomeActivitySuggestionsBinding, SuggestionsViewModel>
        implements ISuggestionsView {
    private static final String TAG = "SuggestionsActivity";

    @Override
    protected int getLayoutId() {
        return R.layout.home_activity_suggestions;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ScreenAutoAdapter.match(this, 375.0f);
        super.onCreate(savedInstanceState);
        viewDataBinding.included.titleBar.setTitle("投诉建议");
        TitleBarUtils.clickLeftBack(viewDataBinding.included.titleBar, this);

        SuggestionsCustomViewModel customViewModel = new SuggestionsCustomViewModel();
        viewDataBinding.tv1.setOnClickListener(v1 -> {
            customViewModel.complaintType = viewDataBinding.tv1.getText().toString();
            viewDataBinding.tv1.setBackground(this.getResources().getDrawable(R.drawable.common_shape_dotted_border_grey1));
        });
        viewDataBinding.tv2.setOnClickListener(v1 -> {
            customViewModel.complaintType = viewDataBinding.tv2.getText().toString();
        });
        viewDataBinding.tv3.setOnClickListener(v1 -> {
            customViewModel.complaintType = viewDataBinding.tv3.getText().toString();
            viewDataBinding.tv3.setBackground(this.getResources().getDrawable(R.drawable.common_shape_dotted_border_grey1));
        });
        viewDataBinding.tv4.setOnClickListener(v1 -> {
            customViewModel.complaintType = viewDataBinding.tv4.getText().toString();
        });
        viewDataBinding.btnCommit.setOnClickListener(v -> {
            customViewModel.complaintContent = viewDataBinding.homeEtSuggest.getText().toString();
            viewModel.initModel();
            viewModel.insert(customViewModel);
        });
    }

    @Override
    protected SuggestionsViewModel getViewModel() {
        return ViewModelProviders.of(this).get(SuggestionsViewModel.class);
    }

    @Override
    protected int getBindingVariable() {
        return 0;
    }

    @Override
    protected void onRetryBtnClick() {

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void onSuccess() {
        finish();
    }
}
