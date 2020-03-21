package com.project.cpx.common.util;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Auther: shuyiwei
 * @Date: 2020/3/19 11:18
 * @Description:
 */
public class Constant {

    //未使用
    public static String INVENTORY_IS_USED_0 ="未使用";
    //部分使用
    public static String INVENTORY_IS_USED_1 ="部分使用";
    //已使用
    public static String INVENTORY_IS_USED_2 ="已使用";

    public static String EXPORT_OPERATION_NAME="运营报表导出";

    public static String EXPORT_MEMBER_NAME="会员报表导出";

    public static String EXPORT_FEE_NAME="运用费用报表导出";

    public static String EXPORT_PURCHASE_NAME = "进货费用报表导出";

    public static String EXPORT_INVENTORY_NAME ="库存管理报表导出";



    public static Map<String, String> EXPORT_OPERATION_MAP = new LinkedHashMap<String,String>(){{
        put("operateDate","时间");
        put("belong","店铺名称");
        put("productCategory","产品类目");
        put("productName","产品名称");
        put("salePrice","销售价（￥）");
        put("saleNum","数量");
        put("saleTotalPrice","销售额（￥）");
        put("rebateNum","返利数");
        put("unRebateNum","待返利数");
        put("actualPrice","实销额（￥）");
        put("price","产品进价（￥）");
        put("constructPrice","施工提成（￥）");
        put("salesCommission","销售提成（￥）");
        put("salesRate","销售利润");
        put("collectionType","收款方式");
        put("constructPreson","施工人");
        put("sales","销售人");
        put("partnerCompanyName","合作公司");
        put("partnerSales","合作公司-销售人");
        put("carType","车型");
        put("carFrame","车架号");
        put("carNo","车牌号");
        put("carOwner","车主姓名");
        put("carOwnerPhone","车主手机号");
        put("remark","备注");
    }};

    public static Map<String, String> EXPORT_MEMBER_MAP = new LinkedHashMap<String,String>(){{
        put("carBrand","品牌");
        put("carType","型号");
        put("carFrame","车架号");
        put("carNo","车牌号");
        put("carOwner","车主姓名");
        put("carBornDate","成产年月");
        put("carOwnerPhone","手机号码");
        put("memberType","会员类型");
        put("remark","备注");
    }};

    public static Map<String, String> EXPORT_FEE_MAP = new LinkedHashMap<String,String>(){{
        put("operateDate","时间");
        put("operateThing","办理事项");
        put("payAmount","支付金额（￥）");
        put("beneficiary","支付对象");
        put("payType","支付方式");
        put("feeType","费用种类");
        put("belong","费用归属");
        put("payer","付款人");
        put("remark","备注");
    }};

    public static Map<String, String> EXPORT_PURCHASE_MAP = new LinkedHashMap<String,String>(){{
        put("operateDate","时间");
        put("belong","店铺名称");
        put("productCategory","产品类目");
        put("productName","产品名称");
        put("carType","车型");
        put("price","单价（￥）");
        put("num","数量");
        put("totalPrice","总价（￥）");
        put("manager","经办人");
        put("supplierCompanyName","公司名称");
        put("supplierPhone","联系人");
        put("supplierPerson","电话");
        put("isPaid","是否付款");
        put("remark","备注");
    }};

    public static Map<String, String> EXPORT_INVENTORY_MAP = new LinkedHashMap<String,String>(){{
        put("operateDate","时间");
        put("productCategory","产品类目");
        put("productName","产品名称");
        put("carType","车型");
        put("belong","店铺名称");
        put("stockNum","库存数量");
        put("price","价格");
        put("manager","经办人");
        put("remark","备注");
    }};
}
