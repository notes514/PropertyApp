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
    /** 获取供求信息 */
    public static final String URL_SUPPLY_INFO = "/supply/listSupply";
    /** 获取活动信息 */
    public static final String URL_EVENT_INFO = "/activity/listActivity";
    /** 图片上传 */
    public static final String URL_IMAGE_UPLOAD = "/image/upload";
    /** 添加报修 */
    public static final String URL_REPAIR_ADD_REPAIR = "/repair/addRepair";
    /** 添加投诉 */
    public static final String URL_COMPLAINT_ADD_COMPLAINT = "/complaint/addComplaint";
}
