package com.guet.user;

import com.guet.base.base.BaseApplication;
import com.guet.common.IModuleInit;

/**
 * 应用模块: 用户模块
 * <p>
 * 类描述: 此类用于初始化操作
 * <p>
 *
 * @author darryrzhoong
 * @since 2020-02-29
 */
public class UserModuleInit implements IModuleInit {

    @Override
    public boolean onInitAhead(BaseApplication application) {
        return false;
    }

    @Override
    public boolean onInitLow(BaseApplication application) {
        return false;
    }
}
