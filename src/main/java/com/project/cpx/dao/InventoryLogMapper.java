package com.project.cpx.dao;

import com.project.cpx.entity.InventoryLogEntity;
import com.project.cpx.entity.query.InventoryLogQuery;

import java.util.List;

public interface InventoryLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InventoryLogEntity record);

    int insertSelective(InventoryLogEntity record);

    InventoryLogEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InventoryLogEntity record);

    int updateByPrimaryKey(InventoryLogEntity record);

    List<InventoryLogEntity> query(InventoryLogQuery query);

    Integer queryCount(InventoryLogQuery query);
}