package com.guet.community.supply.bean;

import java.io.Serializable;

/**
 * 供求实体
 *
 * @author dhxstart
 * @date 2022/4/17 15:12
 */
public class SupplyBean implements Serializable {
    /**
     * 供求ID
     */
    public Integer id;

    /**
     * 供求人员（业主）ID
     */
    public Integer ownerId;

    /**
     * 供求人员（业主）名称
     */
    public String ownerName;

    /**
     * 用户头像Url
     */
    public String avatarUrl;

    /**
     * 供求标题
     */
    public String title;

    /**
     * 供求描述
     */
    public String content;

    /**
     * 供求地点
     */
    public String address;

    /**
     * 供求商品图片
     */
    public String imageUrl;

    /**
     * 状态:0-供求未开始（默认），1-供求进行中，2-供求已结束
     */
    public String status;

    /**
     * 逻辑删除:0-未删除（默认），1-已删除
     */
    public String deleted;

    /**
     * 乐观锁
     */
    public Integer version;

    /**
     * 供求开始时间
     */
    public String startTime;

    /**
     * 供求截止时间
     */
    public String endTime;

    /**
     * 创建时间
     */
    public String gmtCreate;

    /**
     * 更新时间
     */
    public String gmtModified;

    public SupplyBean() {
    }

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

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
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
        return "SupplyBean{" +
                "id=" + id +
                ", ownerId=" + ownerId +
                ", ownerName='" + ownerName + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", address='" + address + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", status='" + status + '\'' +
                ", deleted='" + deleted + '\'' +
                ", version=" + version +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", gmtCreate='" + gmtCreate + '\'' +
                ", gmtModified='" + gmtModified + '\'' +
                '}';
    }
}
