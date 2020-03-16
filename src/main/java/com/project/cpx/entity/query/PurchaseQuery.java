package com.project.cpx.entity.query;

/**
 * @Auther: shuyiwei
 * @Date: 2020/3/1 21:12
 * @Description:
 */
public class PurchaseQuery extends BaseQuery {
    private String operateDate;

    private String productCategory;

    private String productName;

    private String carType;

    private String belong;

    private String manager;

    private String supplierCompanyName;

    private String supplierPhone;

    private String supplierPerson;

    private String isPaid;

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

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getSupplierCompanyName() {
        return supplierCompanyName;
    }

    public void setSupplierCompanyName(String supplierCompanyName) {
        this.supplierCompanyName = supplierCompanyName;
    }

    public String getSupplierPhone() {
        return supplierPhone;
    }

    public void setSupplierPhone(String supplierPhone) {
        this.supplierPhone = supplierPhone;
    }

    public String getSupplierPerson() {
        return supplierPerson;
    }

    public void setSupplierPerson(String supplierPerson) {
        this.supplierPerson = supplierPerson;
    }

    public String getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(String isPaid) {
        this.isPaid = isPaid;
    }

    public String getBelong() {
        return belong;
    }

    public void setBelong(String belong) {
        this.belong = belong;
    }
}
