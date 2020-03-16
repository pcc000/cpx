package com.project.cpx.entity;

import java.util.Date;

public class PartnerCompanyEntity {
    private Integer id;

    private String partnerCompanyName;

    private String partnerSales;

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