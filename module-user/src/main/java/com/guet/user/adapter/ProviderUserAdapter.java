package com.guet.user.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.guet.common.contract.BaseCustomViewModel;
import com.guet.user.repair.bean.RepairCustomViewModel;

import java.util.List;

/**
 *
 *
 * @author dhxstart
 * @date 2022/1/8 22:31
 */
public class ProviderUserAdapter extends BaseProviderMultiAdapter<BaseCustomViewModel> {

    public ProviderUserAdapter() {

    }

    public ProviderUserAdapter(@Nullable List<BaseCustomViewModel> data) {
        super(data);
    }

    @Override
    protected int getItemType(@NonNull List<? extends BaseCustomViewModel> list, int i) {
        if (list.get(i) instanceof RepairCustomViewModel) {
            return 1;
        } else {
            return 0;
        }
    }
}
