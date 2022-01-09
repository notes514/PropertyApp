package com.guet.user.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 此类用于是用于ViewPager2的适配器
 *
 * @author dhxstart
 * @date 2022/1/8 21:10
 */
public class UserFragmentPageAdapter extends FragmentStateAdapter {
    private List<Fragment> mFragmentList;

    public UserFragmentPageAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public UserFragmentPageAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    public UserFragmentPageAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // FragmentStateAdapter内部自己会管理已实例化的fragment对象，不需要考虑复用的问题
        return mFragmentList.get(position);
    }

    @Override
    public int getItemCount() {
        return mFragmentList == null ? 0 : mFragmentList.size();
    }

    public void setData(List<Fragment> fragments) {
        if (mFragmentList == null) {
            mFragmentList = new ArrayList<>();
        }
        mFragmentList.addAll(fragments);
    }
}
