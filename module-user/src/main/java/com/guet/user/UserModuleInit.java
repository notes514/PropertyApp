package com.guet.user;

import com.blankj.utilcode.util.Utils;
import com.guet.base.base.BaseApplication;
import com.guet.base.loadsir.EmptyCallback;
import com.guet.base.loadsir.ErrorCallback;
import com.guet.base.loadsir.LoadingCallback;
import com.guet.base.loadsir.TimeoutCallback;
import com.guet.common.IModuleInit;
import com.guet.common.adapter.ScreenAutoAdapter;
import com.guet.common.api.ApiInterface;
import com.kingja.loadsir.core.LoadSir;
import com.orhanobut.logger.Logger;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.cache.converter.GsonDiskConverter;
import com.zhouyou.http.cache.model.CacheMode;

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
        ScreenAutoAdapter.setup(application);
        EasyHttp.init(application);
        if (application.issDebug()) {
            EasyHttp.getInstance().debug("easyhttp", true);
        }
        EasyHttp.getInstance()
                .setBaseUrl(ApiInterface.URL_BASE)
                .setReadTimeOut(15 * 1000)
                .setWriteTimeOut(15 * 1000)
                .setConnectTimeout(15 * 1000)
                .setRetryCount(3)
                .setCacheDiskConverter(new GsonDiskConverter())
                .setCacheMode(CacheMode.FIRSTREMOTE);
        LoadSir.beginBuilder()
                .addCallback(new ErrorCallback())
                .addCallback(new LoadingCallback())
                .addCallback(new EmptyCallback())
                .addCallback(new TimeoutCallback())
                .setDefaultCallback(LoadingCallback.class)
                .commit();
        Utils.init(application);
        Logger.i("user组件初始化完成 -- onInitAhead");
        return false;
    }

    @Override
    public boolean onInitLow(BaseApplication application) {
        return false;
    }
}
