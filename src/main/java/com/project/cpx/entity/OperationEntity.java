package com.project.cpx.entity;

import java.util.Date;

public class OperationEntity {
    private Integer id;

    private String operateDate;

    private String productCategory;

    private String productName;

    private String belong;

    private Integer salePrice;

    private Integer saleNum;

    private Integer saleTotalPrice;

    private Integer rebateNum;

    private Integer unRebateNum;

    private Integer actualPrice;

    private Integer price;

    private Integer constructPrice;

    private String constructPreson;

    private Integer salesCommission;

    private Integer salesRate;

    private String sales;

    private String collectionType;

    private String partnerCompanyName;

    private String partnerSales;

    private String carType;

    private String carFrame;

    private String carNo;

    private String carOwner;

    private String carOwnerPhone;

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

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory == null ? null : productCategory.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getBelong() {
        return belong;
    }

    public void setBelong(String belong) {
        this.belong = belong == null ? null : belong.trim();
    }

    public Integer getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Integer salePrice) {
        this.salePrice = salePrice;
    }

    public Integer getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(Integer saleNum) {
        this.saleNum = saleNum;
    }

    public Integer getSaleTotalPrice() {
        return saleTotalPrice;
    }

    public void setSaleTotalPrice(Integer saleTotalPrice) {
        this.saleTotalPrice = saleTotalPrice;
    }

    public Integer getRebateNum() {
        return rebateNum;
    }

    public void setRebateNum(Integer rebateNum) {
        this.rebateNum = rebateNum;
    }

    public Integer getUnRebateNum() {
        return unRebateNum;
    }

    public void setUnRebateNum(Integer unRebateNum) {
        this.unRebateNum = unRebateNum;
    }

    public Integer getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(Integer actualPrice) {
        this.actualPrice = actualPrice;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getConstructPrice() {
        return constructPrice;
    }

    public void setConstructPrice(Integer constructPrice) {
        this.constructPrice = constructPrice;
    }

    public String getConstructPreson() {
        return constructPreson;
    }

    public void setConstructPreson(String constructPreson) {
        this.constructPreson = constructPreson == null ? null : constructPreson.trim();
    }

    public Integer getSalesCommission() {
        return salesCommission;
    }

    public void setSalesCommission(Integer salesCommission) {
        this.salesCommission = salesCommission;
    }

    public Integer getSalesRate() {
        return salesRate;
    }

    public void setSalesRate(Integer salesRate) {
        this.salesRate = salesRate;
    }

    public String getSales() {
        return sales;
    }

    public void setSales(String sales) {
        this.sales = sales == null ? null : sales.trim();
    }

    public String getCollectionType() {
        return collectionType;
    }

    public void setCollectionType(String collectionType) {
        this.collectionType = collectionType == null ? null : collectionType.trim();
    }

    public String getPartnerCompanyName() {
        return partnerCompanyName;
    }

    public void setPartnerCompanyName(String partnerCompanyName) {
        this.partnerCompanyName = partnerCompanyName == null ? null : partnerCompanyName.trim();
    }

    public String getPartnerSales() {
        return partnerSales;
    }

    public void setPartnerSales(String partnerSales) {
        this.partnerSales = partnerSales == null ? null : partnerSales.trim();
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType == null ? null : carType.trim();
    }

    public String getCarFrame() {
        return carFrame;
    }

    public void setCarFrame(String carFrame) {
        this.carFrame = carFrame == null ? null : carFrame.trim();
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo == null ? null : carNo.trim();
    }

    public String getCarOwner() {
        return carOwner;
    }

    public void setCarOwner(String carOwner) {
        this.carOwner = carOwner == null ? null : carOwner.trim();
    }

    public String getCarOwnerPhone() {
        return carOwnerPhone;
    }

    public void setCarOwnerPhone(String carOwnerPhone) {
        this.carOwnerPhone = carOwnerPhone == null ? null : carOwnerPhone.trim();
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