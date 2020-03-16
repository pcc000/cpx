package com.project.cpx.entity.query;

/**
 * @Auther: shuyiwei
 * @Date: 2020/3/1 19:33
 * @Description:
 */
public class FeeQuery extends BaseQuery {

    private String operateDate;

    private String operateThing;

    private String beneficiary;

    private String payType;

    private String feeType;

    private String belong;

    private String payer;

    public String getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(String operateDate) {
        this.operateDate = operateDate;
    }

    public String getOperateThing() {
        return operateThing;
    }

    public void setOperateThing(String operateThing) {
        this.operateThing = operateThing;
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
}
