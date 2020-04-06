package com.project.cpx.service.impl;

import com.project.cpx.dao.InventoryLogMapper;
import com.project.cpx.dao.InventoryMapper;
import com.project.cpx.entity.CommonBuilder;
import com.project.cpx.entity.FeeEntity;
import com.project.cpx.entity.InventoryEntity;
import com.project.cpx.entity.InventoryLogEntity;
import com.project.cpx.entity.query.InventoryLogQuery;
import com.project.cpx.entity.query.InventoryQuery;
import com.project.cpx.service.InventoryService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: shuyiwei
 * @Date: 2020/3/3 19:19
 * @Description:
 */
@Service
public class InventoryServiceImpl implements InventoryService {

    @Resource
    private InventoryMapper inventoryMapper;

    @Resource
    private InventoryLogMapper inventoryLogMapper;

    @Override
    public int add(InventoryEntity inventoryEntity) {
        return inventoryMapper.insertSelective(inventoryEntity);
    }

    @Override
    public int update(InventoryEntity inventoryEntity) {
        return inventoryMapper.updateByPrimaryKeySelective(inventoryEntity);
    }

    @Override
    public int deleteById(Integer id) {
        return inventoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<InventoryEntity> query(InventoryQuery query) {
        List<InventoryEntity> resultList = inventoryMapper.query(query);
        if(CollectionUtils.isEmpty(resultList)){
            return new ArrayList<>();
        }
        if(null == query.getTotalRecored()){
            Integer count = inventoryMapper.queryCount(query);
            query.setTotalRecored(count);
        }
        return  resultList;
    }


    @Override
    public int add(InventoryLogEntity entity) {
        return inventoryLogMapper.insertSelective(entity);
    }

    @Override
    public int update(InventoryLogEntity entity) {
        return inventoryLogMapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public int deleteInventoryLogById(Integer id) {
        return inventoryLogMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<InventoryLogEntity> query(InventoryLogQuery query) {
        List<InventoryLogEntity> resultList = inventoryLogMapper.query(query);
        if(CollectionUtils.isEmpty(resultList)){
            return new ArrayList<>();
        }
        if(null == query.getTotalRecored()){
            Integer count = inventoryLogMapper.queryCount(query);
            query.setTotalRecored(count);
        }
        return  resultList;
    }

    @Override
    public synchronized int addInventory(InventoryEntity entity) {
        InventoryQuery query = CommonBuilder.buildAddQuery(entity);
        List<InventoryEntity> inventoryList = inventoryMapper.query(query);
        InventoryLogEntity log = CommonBuilder.addLog(entity);
        inventoryLogMapper.insertSelective(log);
        if(CollectionUtils.isEmpty(inventoryList)){
            inventoryMapper.insertSelective(entity);
        }else{
            InventoryEntity inventoryEntity = inventoryList.get(0);
            inventoryEntity.setStockNum(inventoryEntity.getStockNum()+entity.getStockNum());
            inventoryMapper.updateByPrimaryKeySelective(inventoryEntity);
        }
        return 1;
    }

    @Override
    public synchronized int reduceInventory(InventoryEntity entity) {
        InventoryQuery query = CommonBuilder.buildAddQuery(entity);
        List<InventoryEntity> inventoryList = inventoryMapper.query(query);
        InventoryLogEntity log = CommonBuilder.addLog(entity);
        inventoryLogMapper.insertSelective(log);
        if(CollectionUtils.isEmpty(inventoryList)){
            inventoryMapper.insertSelective(entity);
        }else{
            InventoryEntity inventoryEntity = inventoryList.get(0);
            inventoryEntity.setStockNum(inventoryEntity.getStockNum() - entity.getStockNum());
            inventoryMapper.updateByPrimaryKeySelective(inventoryEntity);
        }
        return 1;
    }
}
