package com.project.cpx.entity.dto;

import java.math.BigDecimal;

/**
 * @Auther: shuyiwei
 * @Date: 2020/3/30 12:30
 * @Description:
 */
public class ProfitDTO {

    private String operateDate;

    private BigDecimal income;

    private BigDecimal grossProfit;

    private BigDecimal incomePerOrder;

    private BigDecimal grossProfitPerOrder;

    public String getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(String operateDate) {
        this.operateDate = operateDate;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public BigDecimal getGrossProfit() {
        return grossProfit;
    }

    public void setGrossProfit(BigDecimal grossProfit) {
        this.grossProfit = grossProfit;
    }

    public BigDecimal getIncomePerOrder() {
        return incomePerOrder;
    }

    public void setIncomePerOrder(BigDecimal incomePerOrder) {
        this.incomePerOrder = incomePerOrder;
    }

    public BigDecimal getGrossProfitPerOrder() {
        return grossProfitPerOrder;
    }

    public void setGrossProfitPerOrder(BigDecimal grossProfitPerOrder) {
        this.grossProfitPerOrder = grossProfitPerOrder;
    }
}
