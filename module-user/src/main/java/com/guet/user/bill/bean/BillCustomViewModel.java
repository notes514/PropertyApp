package com.guet.user.bill.bean;

import com.guet.common.contract.BaseCustomViewModel;

/**
 * 供求实体
 *
 * @author dhxstart
 * @date 2022/1/9 19:54
 */
public class BillCustomViewModel extends BaseCustomViewModel {
    /**
     * 收费明细ID
     */
    public Integer id;

    /**
     * 业主ID
     */
    public Integer ownerId;

    /**
     * 缴费人员（业主）姓名
     */
    public String ownerName;

    /**
     * 收费项目ID
     */
    public Integer chargeId;

    /**
     * 收费项目名称
     */
    public String chargeName;

    /**
     * 应收金额(￥)，单位分
     */
    public String chargeStandard;

    /**
     * 实收金额(￥)，单位分
     */
    public String payReal;

    /**
     * 欠费金额(￥)，单位分
     */
    public String payBalance;

    /**
     * 缴费时间
     */
    public String payTime;

    /**
     * 缴费状态：0-未缴费（默认），1-已缴费
     */
    public String payStatus;

    /**
     * 创建时间
     */
    public String gmtCreate;

    /**
     * 更新时间
     */
    public String gmtModified;
}
