package com.guet.home.suggestions.bean;

import java.time.LocalDateTime;

/**
 * @author dhxstart
 * @date 2022/4/21 18:29
 */
public class SuggestionsBean {
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
     * 逻辑删除:0-未删除（默认），1-已删除
     */
    private String deleted;

    /**
     * 乐观锁
     */
    private Integer version;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 更新时间
     */
    private LocalDateTime gmtModified;

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

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public LocalDateTime getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(LocalDateTime gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public LocalDateTime getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(LocalDateTime gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public String toString() {
        return "SuggestionsBean{" +
                "id=" + id +
                ", ownerId=" + ownerId +
                ", complaintType='" + complaintType + '\'' +
                ", complaintContent='" + complaintContent + '\'' +
                ", status='" + status + '\'' +
                ", handler='" + handler + '\'' +
                ", deleted='" + deleted + '\'' +
                ", version=" + version +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
