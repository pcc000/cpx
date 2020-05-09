package com.project.cpx.entity;

import com.project.cpx.common.util.Constant;
import com.project.cpx.entity.dto.FeeDTO;
import com.project.cpx.entity.query.InventoryQuery;
import org.springframework.beans.BeanUtils;
import sun.security.krb5.Config;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @Auther: shuyiwei
 * @Date: 2020/2/29 23:03
 * @Description:
 */
public class CommonBuilder {

    public static UserEntity buildUserQuery(UserEntity userEntity){
        UserEntity result = new UserEntity();
        result.setUserName(userEntity.getUserName());
        return result;
    }

    public static ConfigEntity buildConfigQuery(ConfigEntity entity){
        ConfigEntity result = new ConfigEntity();
        result.setType(entity.getType());
        result.setKey(entity.getKey());
        return result;
    }

    public static FeeEntity buildFeeEntity(FeeDTO dto){
        FeeEntity feeEntity = new FeeEntity();
        feeEntity.setOperateDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        feeEntity.setPayAmount(dto.getPayAmount());
        BeanUtils.copyProperties(dto,feeEntity);
        return feeEntity;
    }

    public static LoginLogEntity buildLoginLog(UserEntity userEntity){
        LoginLogEntity loginLogEntity = new LoginLogEntity();
        loginLogEntity.setUserName(userEntity.getUserName());
        loginLogEntity.setSessionId(UUID.randomUUID().toString());
        return loginLogEntity;
    }

    public static LoginLogEntity buildLoginQuery(String sessionId){
        LoginLogEntity loginLogEntity = new LoginLogEntity();
        loginLogEntity.setSessionId(sessionId);
        return loginLogEntity;
    }

    public static InventoryQuery buildAddQuery(InventoryEntity entity){
        InventoryQuery query = new InventoryQuery();
        query.setBelong(entity.getBelong());
        query.setProductCategory(entity.getProductCategory());
        query.setProductName(entity.getProductName());
//        query.setPrice(entity.getPrice());
//        query.setCarType(entity.getCarType());
        return query;
    }

    public static InventoryLogEntity addLog(InventoryEntity entity){
        InventoryLogEntity log = new InventoryLogEntity();
        log.setOperateDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        log.setBelong(entity.getBelong());
        log.setBillNo(entity.getBillNo());
        log.setCarType(entity.getCarType());
        log.setManager(entity.getManager());
        log.setOptNum(entity.getStockNum());
        log.setPrice(entity.getPrice());
        log.setProductCategory(entity.getProductCategory());
        log.setProductName(entity.getProductName());
        log.setIsUsed(Constant.INVENTORY_IS_USED_0);
        return log;
    }

    public static InventoryEntity buildInventoyByPurchase(PurchaseEntity entity) {
        InventoryEntity inventoryEntity = new InventoryEntity();
        inventoryEntity.setOperateDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        inventoryEntity.setStockNum(entity.getNum());
        inventoryEntity.setBelong(entity.getBelong());
        inventoryEntity.setProductName(entity.getProductName());
        inventoryEntity.setProductCategory(entity.getProductCategory());
        inventoryEntity.setPrice(entity.getPrice());
        inventoryEntity.setBillNo("P"+entity.getId());
        inventoryEntity.setCarType(entity.getCarType());
        return inventoryEntity;
    }

    public static InventoryEntity buildInventoyByOperation(OperationEntity entity) {
        InventoryEntity inventoryEntity = new InventoryEntity();
        inventoryEntity.setOperateDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        inventoryEntity.setStockNum(entity.getSaleNum());
        inventoryEntity.setBelong(entity.getBelong());
        inventoryEntity.setProductName(entity.getProductName());
        inventoryEntity.setProductCategory(entity.getProductCategory());
        inventoryEntity.setPrice(entity.getPrice());
        inventoryEntity.setBillNo("O"+entity.getId());
        inventoryEntity.setCarType(entity.getCarType());
        return inventoryEntity;
    }
}
