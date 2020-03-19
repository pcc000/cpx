package com.project.cpx.entity;

import java.math.BigDecimal;
import java.util.Date;

public class FeeEntity {
    private Integer id;

    private String operateDate;

    private String operateThing;

    private BigDecimal payAmount;

    private String beneficiary;

    private String payType;

    private String feeType;

    private String belong;

    private String payer;

    private String remark;

    private Date gmtCreate;

    private Date gmtModify;

    private Byte rowStatus;

    private Integer rowVersion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(String operateDate) {
        this.operateDate = operateDate == null ? null : operateDate.trim();
    }

    public String getOperateThing() {
        return operateThing;
    }

    public void setOperateThing(String operateThing) {
        this.operateThing = operateThing == null ? null : operateThing.trim();
    }


    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public String getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(String beneficiary) {
        this.beneficiary = beneficiary == null ? null : beneficiary.trim();
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType == null ? null : feeType.trim();
    }

    public String getBelong() {
        return belong;
    }

    public void setBelong(String belong) {
        this.belong = belong == null ? null : belong.trim();
    }

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer == null ? null : payer.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

    public Byte getRowStatus() {
        return rowStatus;
    }

    public void setRowStatus(Byte rowStatus) {
        this.rowStatus = rowStatus;
    }

    public Integer getRowVersion() {
        return rowVersion;
    }

    public void setRowVersion(Integer rowVersion) {
        this.rowVersion = rowVersion;
    }
}