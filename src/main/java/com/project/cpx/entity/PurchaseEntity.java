package com.project.cpx.entity;

import java.math.BigDecimal;
import java.util.Date;

public class PurchaseEntity {
    private Integer id;

    private String operateDate;

    private String productCategory;

    private String productName;

    private String carType;

    private String belong;

    private BigDecimal price;

    private Integer num;

    private BigDecimal totalPrice;

    private String manager;

    private String supplierCompanyName;

    private String supplierPhone;

    private String supplierPerson;

    private String isPaid;

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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType == null ? null : carType.trim();
    }


    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager == null ? null : manager.trim();
    }

    public String getSupplierCompanyName() {
        return supplierCompanyName;
    }

    public void setSupplierCompanyName(String supplierCompanyName) {
        this.supplierCompanyName = supplierCompanyName == null ? null : supplierCompanyName.trim();
    }

    public String getSupplierPhone() {
        return supplierPhone;
    }

    public void setSupplierPhone(String supplierPhone) {
        this.supplierPhone = supplierPhone == null ? null : supplierPhone.trim();
    }

    public String getSupplierPerson() {
        return supplierPerson;
    }

    public void setSupplierPerson(String supplierPerson) {
        this.supplierPerson = supplierPerson == null ? null : supplierPerson.trim();
    }

    public String getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(String isPaid) {
        this.isPaid = isPaid == null ? null : isPaid.trim();
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

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getBelong() {
        return belong;
    }

    public void setBelong(String belong) {
        this.belong = belong;
    }
}