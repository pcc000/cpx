package com.project.cpx.entity;

import java.util.Date;

public class MemberEntity {
    private Integer id;

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