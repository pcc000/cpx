package com.project.cpx.service;

import com.project.cpx.entity.ConfigEntity;
import com.project.cpx.entity.InventoryEntity;
import com.project.cpx.entity.InventoryLogEntity;
import com.project.cpx.entity.query.InventoryLogQuery;
import com.project.cpx.entity.query.InventoryQuery;

import java.util.List;

/**
 * @Auther: shuyiwei
 * @Date: 2020/3/3 19:18
 * @Description:
 */
public interface InventoryService {

    int add(InventoryEntity entity);

    int update(InventoryEntity entity);

    int deleteById(Integer id);

    List<InventoryEntity> query(InventoryQuery entity);

    int add(InventoryLogEntity entity);

    int update(InventoryLogEntity entity);

    int deleteInventoryLogById(Integer id);

    List<InventoryLogEntity> query(InventoryLogQuery query);

    int addInventory(InventoryEntity entity);
}
