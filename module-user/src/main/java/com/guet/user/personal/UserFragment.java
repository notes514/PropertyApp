package com.guet.user.personal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProviders;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.guet.base.fragment.MvvmBaseFragment;
import com.guet.common.router.RouterFragmentPath;
import com.guet.user.R;
import com.guet.user.about.AboutActivity;
import com.guet.user.bill.BillActivity;
import com.guet.user.complaint.ComplaintActivity;
import com.guet.user.databinding.UserFragmentLayoutBinding;
import com.guet.user.feedback.FeedbackActivity;
import com.guet.user.login.LoginActivity;
import com.guet.user.msg.MsgActivity;
import com.guet.user.personal.bean.UserBean;
import com.guet.user.property.PropertyActivity;
import com.guet.user.repair.RepairActivity;
import com.guet.user.trade.TradeActivity;
import com.guet.user.view.DLAnimView;

/**
 * 用户个人中心
 *
 * @author dhxstart
 * @date 2022/1/8 10:49
 */
@Route(path = RouterFragmentPath.User.PAGER_USER)
public class UserFragment extends MvvmBaseFragment<UserFragmentLayoutBinding, UserViewModel>
        implements IUserView {
    private ActivityResultLauncher<Intent> resultLauncher;

    @Override
    public int getLayoutId() {
        return R.layout.user_fragment_layout;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
        initView();
    }

    private void initData() {
        viewModel.initModel();
        resultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), result -> {
                    Intent intent = result.getData();
                    if (intent == null) {
                        return;
                    }
                    viewModel.getUserInfo(intent.getStringExtra("token"));
                });
    }

    private void initView() {
        if (getActivity() == null) {
            return;
        }
        // 设置登录背景图片
        DLAnimView dlAnimView = new DLAnimView(getActivity());
        ConstraintLayout.LayoutParams layoutParams =
                new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT, 128);
        viewDataBinding.userConstraint.addView(dlAnimView, layoutParams);

        Glide.with(getActivity()).load(getContext().getDrawable(R.drawable.avatar))
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(viewDataBinding.ivAvatar);

        viewDataBinding.ivAvatar.setOnClickListener(v -> {
            resultLauncher.launch(new Intent(getActivity(), LoginActivity.class));
        });
        viewDataBinding.clTrade.setOnClickListener(v -> {
            TradeActivity.startAction(getActivity());
        });
        viewDataBinding.clRepair.setOnClickListener(v -> {
            RepairActivity.startAction(getActivity());
        });
        viewDataBinding.llProperty.setOnClickListener(v -> {
            PropertyActivity.startAction(getActivity());
        });
        viewDataBinding.llBill.setOnClickListener(v -> {
            BillActivity.startAction(getActivity());
        });
        viewDataBinding.llMsgManager.setOnClickListener(v -> {
            MsgActivity.startAction(getActivity());
        });
        viewDataBinding.llComplaint.setOnClickListener(v -> {
            ComplaintActivity.startAction(getActivity());
        });
        viewDataBinding.llFeedBack.setOnClickListener(v -> {
            FeedbackActivity.startAction(getActivity());
        });
        viewDataBinding.llAbout.setOnClickListener(v -> {
            AboutActivity.startAction(getActivity());
        });
        viewDataBinding.llSetting.setOnClickListener(v -> {
        });
    }

    @Override
    public int getBindingVariable() {
        return 0;
    }

    @Override
    protected UserViewModel getViewModel() {
        return ViewModelProviders.of(this).get(UserViewModel.class);
    }

    @Override
    protected void onRetryBtnClick() {

    }

    @Override
    public void showUserInfo(UserBean userBean) {
        if (userBean == null) {
            return;
        }
        viewDataBinding.tvUsername.setText(userBean.getUsername());
    }
}