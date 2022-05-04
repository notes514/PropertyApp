package com.guet.user.trade.bean;


import com.guet.common.contract.BaseCustomViewModel;

/**
 * 供求实体
 *
 * @author dhxstart
 * @date 2022/1/9 19:54
 */
public class TradeCustomViewModel extends BaseCustomViewModel {
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
}
