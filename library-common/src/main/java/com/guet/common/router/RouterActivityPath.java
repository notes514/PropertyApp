package com.guet.common.router;

/**
 * 应用模块: 组件化路由
 * <p>
 * 类描述: 用于在组件化开发中,利用ARouter 进行Activity跳转的统一路径注册, 注册时请写好注释、标注界面功能业务
 * <p>
 *
 * @author darryrzhoong
 * @since 2020-02-25
 */
public class RouterActivityPath {
    /**
     * main组件
     */
    public static class Main {
        private static final String MAIN = "/main";

        /**
         * 主页面
         */
        public static final String PAGER_MAIN = MAIN + "/Main";
    }

    /**
     * 视频播放(video)组件
     */
    public static class Video {
        private static final String VIDEO = "/video";

        /* 视频播放界面 */
        public static final String PAGER_VIDEO = VIDEO + "/Video";

    }

    public static class User {
        private static final String USER = "/user";

        /**
         * 登录界面
         */
        public static final String PAGER_LOGIN = USER + "/login";

        /**
         * 注册页面
         */
        public static final String PAGER_REGIST = USER + "/regist";

        /**
         * 交易页面
         */
        public static final String PAGER_TRADE = USER + "/trade";

        /**
         * 报修页面
         */
        public static final String PAGER_REPAIR = USER + "/repair";

        /**
         * 物业信息页面
         */
        public static final String PAGER_PROPERTY = USER + "/property";

        /**
         * 账单页面
         */
        public static final String PAGER_BILL = USER + "/bill";

        /**
         * 消息管理页面
         */
        public static final String PAGER_MSG = USER + "/msg";

        /**
         * 意见反馈页面
         */
        public static final String PAGER_FEEDBACK = USER + "/feedback";

        /**
         * 关于页面
         */
        public static final String PAGER_ABOUT = USER + "/about";

        /**
         * 设置页面
         */
        public static final String PAGER_SETTING = USER + "/setting";

        /**
         * 关注页面
         */
        public static final String PAGER_ATTENTION = USER + "/attention";
    }
}
