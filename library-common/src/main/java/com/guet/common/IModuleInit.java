package com.guet.common;

import com.guet.base.base.BaseApplication;

/**
 * 此类用于模块初始化
 *
 * @author dhxstart
 * @date 2022/1/3 18:28
 */
public interface IModuleInit {

    /**
     * 需要优先初始化的
     */
    boolean onInitAhead(BaseApplication application);

    /**
     * 可以后初始化的
     */
    boolean onInitLow(BaseApplication application);
}
