package com.guet.user.bill.bean;


import com.guet.common.contract.BaseCustomViewModel;

import java.math.BigDecimal;

/**
 * 供求实体
 *
 * @author dhxstart
 * @date 2022/1/9 19:54
 */
public class BillBean extends BaseCustomViewModel {
    /**
     * 收费明细ID
     */
    private Integer id;

    /**
     * 业主ID
     */
    private Integer ownerId;

    /**
     * 缴费人员（业主）姓名
     */
    private String ownerName;

    /**
     * 收费项目ID
     */
    private Integer chargeId;

    /**
     * 收费项目名称
     */
    private String chargeName;

    /**
     * 应收金额(￥)，单位分
     */
    private String chargeStandard;

    /**
     * 实收金额(￥)，单位分
     */
    private String payReal;

    /**
     * 欠费金额(￥)，单位分
     */
    private String payBalance;

    /**
     * 缴费时间
     */
    private String payTime;

    /**
     * 缴费状态：0-未缴费（默认），1-已缴费
     */
    private String payStatus;

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

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Integer getChargeId() {
        return chargeId;
    }

    public void setChargeId(Integer chargeId) {
        this.chargeId = chargeId;
    }

    public String getChargeName() {
        return chargeName;
    }

    public void setChargeName(String chargeName) {
        this.chargeName = chargeName;
    }

    public String getChargeStandard() {
        return chargeStandard;
    }

    public void setChargeStandard(String chargeStandard) {
        this.chargeStandard = chargeStandard;
    }

    public String getPayReal() {
        return payReal;
    }

    public void setPayReal(String payReal) {
        this.payReal = payReal;
    }

    public String getPayBalance() {
        return payBalance;
    }

    public void setPayBalance(String payBalance) {
        this.payBalance = payBalance;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
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
        return "BillBean{" +
                "id=" + id +
                ", ownerId=" + ownerId +
                ", ownerName='" + ownerName + '\'' +
                ", chargeId=" + chargeId +
                ", chargeName='" + chargeName + '\'' +
                ", chargeStandard='" + chargeStandard + '\'' +
                ", payReal=" + payReal +
                ", payBalance=" + payBalance +
                ", payTime='" + payTime + '\'' +
                ", payStatus='" + payStatus + '\'' +
                ", gmtCreate='" + gmtCreate + '\'' +
                ", gmtModified='" + gmtModified + '\'' +
                '}';
    }
}
