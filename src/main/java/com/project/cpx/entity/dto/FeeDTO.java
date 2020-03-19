package com.project.cpx.entity.dto;

import java.math.BigDecimal;

/**
 * @Auther: shuyiwei
 * @Date: 2020/3/1 20:08
 * @Description:
 */
public class FeeDTO {

    private Integer id;

    private String operateThing;

    private BigDecimal payAmount;

    private String beneficiary;

    private String payType;

    private String feeType;

    private String belong;

    private String payer;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOperateThing() {
        return operateThing;
    }

    public void setOperateThing(String operateThing) {
        this.operateThing = operateThing;
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
        this.beneficiary = beneficiary;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public String getBelong() {
        return belong;
    }

    public void setBelong(String belong) {
        this.belong = belong;
    }

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
