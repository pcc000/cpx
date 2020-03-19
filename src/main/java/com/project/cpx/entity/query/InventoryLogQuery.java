package com.project.cpx.entity.query;

import java.math.BigDecimal;

/**
 * @Auther: shuyiwei
 * @Date: 2020/3/3 19:29
 * @Description:
 */
public class InventoryLogQuery  extends BaseQuery {

    private String billNo;

    private String operateDate;

    private String productCategory;

    private String productName;

    private String carType;

    private String belong;

    private Integer optNum;

    private BigDecimal price;

    private String manager;

    private String isUsed;

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(String operateDate) {
        this.operateDate = operateDate;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBelong() {
        return belong;
    }

    public void setBelong(String belong) {
        this.belong = belong;
    }

    public Integer getOptNum() {
        return optNum;
    }

    public void setOptNum(Integer optNum) {
        this.optNum = optNum;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(String isUsed) {
        this.isUsed = isUsed;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }
}
