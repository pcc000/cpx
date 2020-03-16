package com.project.cpx.service;

import com.project.cpx.entity.PurchaseEntity;
import com.project.cpx.entity.query.PurchaseQuery;

import java.util.List;

/**
 * @Auther: shuyiwei
 * @Date: 2020/3/1 21:09
 * @Description:
 */
public interface PurchaseService {
    int add(PurchaseEntity entity);

    int update(PurchaseEntity entity);

    int deleteById(Integer id);

    List<PurchaseEntity> query(PurchaseQuery query);

    List<String> queryByProductName(PurchaseQuery entity);

    List<String> queryByCarType(PurchaseQuery entity);

    List<String> queryByManager(PurchaseQuery entity);

    List<PurchaseEntity> queryBySupplierCompanyName(PurchaseQuery entity);
}
