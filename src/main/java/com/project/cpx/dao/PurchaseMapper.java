package com.project.cpx.dao;

import com.project.cpx.entity.PurchaseEntity;
import com.project.cpx.entity.query.PurchaseQuery;

import java.util.List;

public interface PurchaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PurchaseEntity record);

    int insertSelective(PurchaseEntity record);

    PurchaseEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PurchaseEntity record);

    int updateByPrimaryKey(PurchaseEntity record);

    List<PurchaseEntity> query(PurchaseQuery query);

    List<String> queryByProductName(PurchaseQuery query);

    List<String> queryByCarType(PurchaseQuery query);

    List<String> queryByManager(PurchaseQuery query);

    List<PurchaseEntity> queryBySupplierCompanyName(PurchaseQuery query);

    Integer queryCount(PurchaseQuery query);
}