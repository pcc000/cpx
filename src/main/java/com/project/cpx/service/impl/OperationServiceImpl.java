package com.project.cpx.service.impl;

import com.project.cpx.common.util.DateUtil;
import com.project.cpx.dao.OperationMapper;
import com.project.cpx.entity.*;
import com.project.cpx.entity.dto.ProfitDTO;
import com.project.cpx.entity.query.OperationQuery;
import com.project.cpx.entity.query.PurchaseQuery;
import com.project.cpx.service.InventoryService;
import com.project.cpx.service.OperationService;
import com.project.cpx.service.PurchaseService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: shuyiwei
 * @Date: 2020/3/3 19:20
 * @Description:
 */
@Service
public class OperationServiceImpl implements OperationService {

    @Resource
    private OperationMapper operationMapper;

    @Resource
    private InventoryService inventoryService;

    @Resource
    private PurchaseService purchaseService;

    @Override
    public int add(OperationEntity entity) {
        entity.setSalePrice(null != entity.getSalePrice() ? entity.getSalePrice() : new BigDecimal(0));
        entity.setSaleNum(null != entity.getSaleNum() ? entity.getSaleNum() : 0);
        entity.setRebateNum(null != entity.getRebateNum() ? entity.getRebateNum() : 0);
        if(null == entity.getPrice() && !StringUtils.isEmpty(entity.getProductCategory()) && !StringUtils.isEmpty(entity.getProductName())){
            PurchaseQuery purchaseQuery = new PurchaseQuery();
            purchaseQuery.setProductCategory(entity.getProductCategory());
            purchaseQuery.setProductName(entity.getProductName());
            List<PurchaseEntity> purchaseEntityList = purchaseService.query(purchaseQuery);
            entity.setPrice(!CollectionUtils.isEmpty(purchaseEntityList) ? purchaseEntityList.get(0).getPrice() : null);
        }
        entity.setPrice(null != entity.getPrice() ? entity.getPrice() : new BigDecimal(0));
        entity.setSaleTotalPrice(entity.getSalePrice().multiply(new BigDecimal(entity.getSaleNum())));
        entity.setActualPrice(entity.getSaleTotalPrice().subtract(new BigDecimal(entity.getRebateNum())));
        entity.setSalesRate(entity.getActualPrice().subtract(entity.getPrice()).intValue());
        Integer result = operationMapper.insertSelective(entity);
        if(result > 0){
            InventoryEntity inventoryEntity = CommonBuilder.buildInventoyByOperation(entity);
            inventoryService.reduceInventory(inventoryEntity);
        }
        return result;
    }

    @Override
    public int update(OperationEntity entity) {
        entity.setSalePrice(null != entity.getSalePrice() ? entity.getSalePrice() : new BigDecimal(0));
        entity.setSaleNum(null != entity.getSaleNum() ? entity.getSaleNum() : 0);
        entity.setRebateNum(null != entity.getRebateNum() ? entity.getRebateNum() : 0);
        if(null == entity.getPrice() && !StringUtils.isEmpty(entity.getProductCategory()) && !StringUtils.isEmpty(entity.getProductName())){
            PurchaseQuery purchaseQuery = new PurchaseQuery();
            purchaseQuery.setProductCategory(entity.getProductCategory());
            purchaseQuery.setProductName(entity.getProductName());
            List<PurchaseEntity> purchaseEntityList = purchaseService.query(purchaseQuery);
            entity.setPrice(!CollectionUtils.isEmpty(purchaseEntityList) ? purchaseEntityList.get(0).getPrice() : null);
        }
        entity.setPrice(null != entity.getPrice() ? entity.getPrice() : new BigDecimal(0));
        entity.setSaleTotalPrice(entity.getSalePrice().multiply(new BigDecimal(entity.getSaleNum())));
        entity.setActualPrice(entity.getSaleTotalPrice().subtract(new BigDecimal(entity.getRebateNum())));
        entity.setSalesRate(entity.getActualPrice().subtract(entity.getPrice()).intValue());
        return operationMapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public int deleteById(Integer id) {
        return operationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<OperationEntity> query(OperationQuery query) {
        List<OperationEntity> resultList = operationMapper.query(query);
        if(CollectionUtils.isEmpty(resultList)){
            return new ArrayList<>();
        }
        if(null == query.getTotalRecored()){
            Integer count = operationMapper.queryCount(query);
            query.setTotalRecored(count);
        }
        resultList.stream().forEach(operationEntity -> {
            operationEntity.setSaleTotalPrice(operationEntity.getSalePrice().multiply(new BigDecimal(operationEntity.getSaleNum())));
            operationEntity.setActualPrice(operationEntity.getSaleTotalPrice().subtract(new BigDecimal(operationEntity.getRebateNum())));
            operationEntity.setSalesRate(operationEntity.getActualPrice().subtract(operationEntity.getPrice()).intValue());
        });
        return  resultList;
    }

    @Override
    public List<ProfitDTO> queryByDate(OperationQuery query) {
        if(null != query && StringUtils.isEmpty(query.getMonth()) ){
            query.setStart(DateUtil.getMonthFirstDay()+"");
            query.setEnd(DateUtil.getMonthLastDay()+"");
        }else{
            Integer year = null;
            Integer month = null;
            try {
                year = Integer.valueOf(query.getMonth().substring(0,4));
                month = Integer.valueOf(query.getMonth().substring(5,7));
            }catch (Exception e){
                year= null;
                month =null;
            }
            year = null ==year ? DateUtil.getDefaultYear() :year;
            month = null ==month ? DateUtil.getDefaultMonth() :month;
            query.setStart(DateUtil.getMonthFirstDayStr(year,month));
            query.setEnd(DateUtil.getMonthLastDayStr(year,month));
        }

        List<ProfitDTO> resultList = operationMapper.queryByDate(query);
        if(CollectionUtils.isEmpty(resultList)){
            return new ArrayList<>();
        }
        if(null == query.getTotalRecored()){
            query.setTotalRecored(resultList.size());
        }
        return resultList;
    }

}
