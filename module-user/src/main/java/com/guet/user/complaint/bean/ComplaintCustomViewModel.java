package com.guet.user.complaint.bean;

import com.guet.common.contract.BaseCustomViewModel;

/**
 * 投诉实体
 *
 * @author dhxstart
 * @date 2022/1/9 19:54
 */
public class ComplaintCustomViewModel extends BaseCustomViewModel {
    /**
     * 投诉ID
     */
    public Integer id;

    /**
     * 投诉人员（业主）ID
     */
    public Integer ownerId;

    /**
     * 投诉类型
     */
    public String complaintType;

    /**
     * 投诉内容
     */
    public String complaintContent;

    /**
     * 处理状态：0-待受理，1-受理中，2-受理完毕
     */
    public String status;

    /**
     * 处理人
     */
    public String handler;

    /**
     * 创建时间
     */
    public String gmtCreate;

    /**
     * 更新时间
     */
    public String gmtModified;
}
