package com.guet.user.repair.bean;

/**
 * 报修信息实体
 *
 * @author dhxstart
 * @date 2022/1/8 21:55
 */
public class RepairBean {
    /**
     * 报修ID
     */
    private Integer id;

    /**
     * 所属楼栋ID
     */
    private Integer buildingId;

    /**
     * 所属楼栋名称
     */
    private String buildingName;

    /**
     * 报修人员（业主）ID
     */
    private Integer ownerId;

    /**
     * 报修人员（业主）名称
     */
    private String ownerName;

    /**
     * 报修类型
     */
    private String repairType;

    /**
     * 报修内容
     */
    private String repairContent;

    /**
     * 处理状态：0-待受理，1-受理中，2-受理完毕
     */
    private String status;

    private String imageUrl;

    /**
     * 逻辑删除:0-未删除（默认），1-已删除
     */
    private String deleted;

    /**
     * 处理人
     */
    private String handler;

    /**
     * 乐观锁
     */
    private Integer version;

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

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
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

    public String getRepairType() {
        return repairType;
    }

    public void setRepairType(String repairType) {
        this.repairType = repairType;
    }

    public String getRepairContent() {
        return repairContent;
    }

    public void setRepairContent(String repairContent) {
        this.repairContent = repairContent;
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

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
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
        return "RepairBean{" +
                "id=" + id +
                ", buildingId=" + buildingId +
                ", buildingName='" + buildingName + '\'' +
                ", ownerId=" + ownerId +
                ", ownerName='" + ownerName + '\'' +
                ", repairType='" + repairType + '\'' +
                ", repairContent='" + repairContent + '\'' +
                ", status='" + status + '\'' +
                ", deleted='" + deleted + '\'' +
                ", handler='" + handler + '\'' +
                ", version=" + version +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
