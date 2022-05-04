package com.guet.user.complaint.bean;

import com.guet.common.contract.BaseCustomViewModel;

/**
 * 投诉实体
 *
 * @author dhxstart
 * @date 2022/1/9 19:54
 */
public class ComplaintBean extends BaseCustomViewModel {
    /**
     * 投诉ID
     */
    private Integer id;

    /**
     * 投诉人员（业主）ID
     */
    private Integer ownerId;

    /**
     * 投诉类型
     */
    private String complaintType;

    /**
     * 投诉内容
     */
    private String complaintContent;

    /**
     * 处理状态：0-待受理，1-受理中，2-受理完毕
     */
    private String status;

    /**
     * 处理人
     */
    private String handler;

    /**
     * 创建时间
     */
    private String gmtCreate;

    /**
     * 更新时间
     */
    private String gmtModified;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public String getComplaintType() {
        return complaintType;
    }

    public void setComplaintType(String complaintType) {
        this.complaintType = complaintType;
    }

    public String getComplaintContent() {
        return complaintContent;
    }

    public void setComplaintContent(String complaintContent) {
        this.complaintContent = complaintContent;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }

    public String getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(String gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(String gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public String toString() {
        return "ComplaintBean{" +
                "id=" + id +
                ", ownerId=" + ownerId +
                ", complaintType='" + complaintType + '\'' +
                ", complaintContent='" + complaintContent + '\'' +
                ", status='" + status + '\'' +
                ", handler='" + handler + '\'' +
                ", gmtCreate='" + gmtCreate + '\'' +
                ", gmtModified='" + gmtModified + '\'' +
                '}';
    }
}
