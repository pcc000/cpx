package com.project.cpx.service;

import com.project.cpx.entity.FeeEntity;
import com.project.cpx.entity.query.FeeQuery;

import java.util.List;

/**
 * @Auther: shuyiwei
 * @Date: 2020/3/1 19:03
 * @Description:
 */
public interface FeeService {

    int add(FeeEntity feeEntity);

    int update(FeeEntity feeEntity);

    int deleteById(Integer id);

    List<FeeEntity> query(FeeQuery query);

    List<String> queryByOperateThing(FeeQuery entity);

    List<String> queryByBeneficiary(FeeQuery entity);

    List<String> queryByPayer(FeeQuery entity);
}
