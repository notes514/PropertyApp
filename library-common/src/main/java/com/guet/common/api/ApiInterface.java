package com.guet.common.api;

/**
 * @author dhxstart
 * @date 2022/1/12 12:36
 */
public class ApiInterface {
    /** base url */
    public static final String URL_BASE = "http://192.168.1.105:8080";
    /** 用户登录 */
    public static final String URL_LOGIN = "/login/auth";
    /** 获取当前用户信息 */
    public static final String URL_USER_INFO = "/login/getInfo";
    /** 获取通知信息 */
    public static final String URL_NOTICE_INFO = "/notice/listNotice";
}
