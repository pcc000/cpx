package com.project.cpx.entity.query;

/**
 * @Auther: shuyiwei
 * @Date: 2020/3/3 19:28
 * @Description:
 */
public class PartnerCompanyQuery extends BaseQuery {

    private String partnerCompanyName;

    private String partnerSales;

    public String getPartnerCompanyName() {
        return partnerCompanyName;
    }

    public void setPartnerCompanyName(String partnerCompanyName) {
        this.partnerCompanyName = partnerCompanyName;
    }

    public String getPartnerSales() {
        return partnerSales;
    }

    public void setPartnerSales(String partnerSales) {
        this.partnerSales = partnerSales;
    }
}
