package com.guet.user.property.bean;

import java.math.BigDecimal;

/**
 * @author dhxstart
 * @date 2022/1/10 12:37
 */
public class PropertyCustomViewModel {

    /**
     * 房屋ID
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
     * 所属单元ID
     */
    public Integer unitId;

    /**
     * 所属单元名称
     */
    public String unitName;

    /**
     * 房产编码
     */
    public String code;

    /**
     * 房产名称
     */
    public String name;

    /**
     * 所属（业主）ID
     */
    public Integer ownerId;

    /**
     * 所属户主（业主）名称
     */
    public String ownerName;

    /**
     * 面积
     */
    public BigDecimal area;

    /**
     * 房间数
     */
    public Integer roomNum;

    /**
     * 楼层
     */
    public Integer floor;

    /**
     * 联系方式
     */
    public Integer telephone;

    /**
     * 房屋状态：0-未销售（默认），1-已入住
     */
    public String status;

    /**
     * 房屋状态：0-未销售（默认），1-已入住
     */
    public String refinedDecoration;

    /**
     * 房屋描述
     */
    public String description;

    /**
     * 入住时间
     */
    public String liveTime;

    /**
     * 创建时间
     */
    public String gmtCreate;

    /**
     * 更新时间
     */
    public String gmtModified;
}
