package com.project.cpx.entity.query;

/**
 * @Auther: shuyiwei
 * @Date: 2020/3/16 21:08
 * @Description:
 */
public class MemberQuery extends BaseQuery {

    private String carType;

    private String carFrame;

    private String carNo;

    private String carOwner;

    private String carOwnerPhone;

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarFrame() {
        return carFrame;
    }

    public void setCarFrame(String carFrame) {
        this.carFrame = carFrame;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public String getCarOwner() {
        return carOwner;
    }

    public void setCarOwner(String carOwner) {
        this.carOwner = carOwner;
    }

    public String getCarOwnerPhone() {
        return carOwnerPhone;
    }

    public void setCarOwnerPhone(String carOwnerPhone) {
        this.carOwnerPhone = carOwnerPhone;
    }
}
