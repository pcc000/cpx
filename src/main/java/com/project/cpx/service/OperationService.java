package com.project.cpx.service;

import com.project.cpx.entity.InventoryEntity;
import com.project.cpx.entity.OperationEntity;
import com.project.cpx.entity.query.OperationQuery;

import java.util.List;

/**
 * @Auther: shuyiwei
 * @Date: 2020/3/3 19:18
 * @Description:
 */
public interface OperationService {

    int add(OperationEntity entity);

    int update(OperationEntity entity);

    int deleteById(Integer id);

    List<OperationEntity> query(OperationQuery query);
}
