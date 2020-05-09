package com.project.cpx.service.impl;

import com.project.cpx.dao.PurchaseMapper;
import com.project.cpx.entity.CommonBuilder;
import com.project.cpx.entity.InventoryEntity;
import com.project.cpx.entity.PurchaseEntity;
import com.project.cpx.entity.query.PurchaseQuery;
import com.project.cpx.service.InventoryService;
import com.project.cpx.service.PurchaseService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: shuyiwei
 * @Date: 2020/3/1 21:10
 * @Description:
 */
@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Resource
    private PurchaseMapper purchaseMapper;

    @Resource
    private InventoryService inventoryService;

    @Override
    public int add(PurchaseEntity entity) {
        int result = purchaseMapper.insertSelective(entity);
        if(result > 0){
            InventoryEntity inventoryEntity = CommonBuilder.buildInventoyByPurchase(entity);
            inventoryService.addInventory(inventoryEntity);
        }
        return result;
    }

    @Override
    public int update(PurchaseEntity entity) {
        return purchaseMapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public int deleteById(Integer id) {
        return purchaseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<PurchaseEntity> query(PurchaseQuery query) {
        List<PurchaseEntity> resultList = purchaseMapper.query(query);
        if(CollectionUtils.isEmpty(resultList)){
            return  new ArrayList<>();
        }
        if(null == query.getTotalRecored()){
            query.setTotalRecored(purchaseMapper.queryCount(query));
        }
        resultList.stream().forEach(purchaseEntity -> {
            purchaseEntity.setTotalPrice(purchaseEntity.getPrice().multiply(new BigDecimal(purchaseEntity.getNum())));
        });
        return resultList;
    }

    @Override
    public List<String> queryByProductName(PurchaseQuery query) {
        return purchaseMapper.queryByProductName(query);
    }

    @Override
    public List<String> queryByCarType(PurchaseQuery query) {
        return purchaseMapper.queryByCarType(query);
    }

    @Override
    public List<String> queryByManager(PurchaseQuery query) {
        return purchaseMapper.queryByManager(query);
    }

    @Override
    public List<PurchaseEntity> queryBySupplierCompanyName(PurchaseQuery query) {
        return purchaseMapper.queryBySupplierCompanyName(query);
    }
}
