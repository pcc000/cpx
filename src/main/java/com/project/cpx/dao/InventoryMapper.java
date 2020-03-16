package com.project.cpx.dao;

import com.project.cpx.entity.InventoryEntity;
import com.project.cpx.entity.query.InventoryQuery;

import java.util.List;

public interface InventoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InventoryEntity record);

    int insertSelective(InventoryEntity record);

    InventoryEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InventoryEntity record);

    int updateByPrimaryKey(InventoryEntity record);

    List<InventoryEntity> query(InventoryQuery query);

    Integer queryCount(InventoryQuery query);
}