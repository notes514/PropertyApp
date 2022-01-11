package com.guet.user;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.guet.base.fragment.MvvmBaseFragment;
import com.guet.base.viewmodel.IMvvmBaseViewModel;
import com.guet.common.router.RouterFragmentPath;
import com.guet.user.about.AboutActivity;
import com.guet.user.bill.BillActivity;
import com.guet.user.complaint.ComplaintActivity;
import com.guet.user.databinding.UserFragmentLayoutBinding;
import com.guet.user.feedback.FeedbackActivity;
import com.guet.user.login.LoginActivity;
import com.guet.user.msg.MsgActivity;
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
public class UserFragment extends MvvmBaseFragment<UserFragmentLayoutBinding, IMvvmBaseViewModel> {

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
            ToastUtils.showShort("点击了头像");
            LoginActivity.startAction(getActivity());
        });
        viewDataBinding.clTrade.setOnClickListener(v -> {
            ToastUtils.showShort("点击了我的交易");
            TradeActivity.startAction(getActivity());
        });
        viewDataBinding.clRepair.setOnClickListener(v -> {
            ToastUtils.showShort("点击了我的报修");
            RepairActivity.startAction(getActivity());
        });
        viewDataBinding.llProperty.setOnClickListener(v -> {
            ToastUtils.showShort("点击了物业");
            PropertyActivity.startAction(getActivity());
        });
        viewDataBinding.llBill.setOnClickListener(v -> {
            ToastUtils.showShort("点击账单");
            BillActivity.startAction(getActivity());
        });
        viewDataBinding.llMsgManager.setOnClickListener(v -> {
            ToastUtils.showShort("点击了消息管理");
            MsgActivity.startAction(getActivity());
        });
        viewDataBinding.llComplaint.setOnClickListener(v -> {
            ToastUtils.showShort("点击了公告管理");
            ComplaintActivity.startAction(getActivity());
        });
        viewDataBinding.llFeedBack.setOnClickListener(v -> {
            ToastUtils.showShort("点击了意见反馈");
            FeedbackActivity.startAction(getActivity());
        });
        viewDataBinding.llAbout.setOnClickListener(v -> {
            ToastUtils.showShort("点击了关于");
            AboutActivity.startAction(getActivity());
        });
        viewDataBinding.llSetting.setOnClickListener(v -> {
            ToastUtils.showShort("点击了设置");
        });
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
