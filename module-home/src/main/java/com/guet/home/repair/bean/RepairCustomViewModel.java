package com.guet.home.repair.bean;

/**
 * 
 * 
 * @author dhxstart
 * @date 2022/4/21 9:35
 */
public class RepairCustomViewModel {
    /**
     * 报修ID
     */
    public Integer id;

    /**
     * 所属楼栋ID
     */
    public Integer buildingId;

    /**
     * 所属楼栋名称
     */
    public String buildingName;

    /**
     * 报修人员（业主）ID
     */
    public Integer ownerId;

    /**
     * 报修人员（业主）名称
     */
    public String ownerName;

    /**
     * 报修类型
     */
    public String repairType;

    /**
     * 报修内容
     */
    public String repairContent;

    /**
     * 处理状态：0-待受理，1-受理中，2-受理完毕
     */
    public String status;

    public String imageUrl;

    /**
     * 逻辑删除:0-未删除（默认），1-已删除
     */
    public String deleted;

    /**
     * 处理人
     */
    public String handler;

    /**
     * 乐观锁
     */
    public Integer version;

    /**
     * 创建时间
     */
    public String gmtCreate;

    /**
     * 更新时间
     */
    public String gmtModified;
}
