package com.project.cpx.dao;

import com.project.cpx.entity.FeeEntity;
import com.project.cpx.entity.query.FeeQuery;

import java.util.List;

public interface FeeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FeeEntity record);

    int insertSelective(FeeEntity record);

    FeeEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FeeEntity record);

    int updateByPrimaryKey(FeeEntity record);

    List<FeeEntity> query(FeeQuery query);

    List<String> queryByOperateThing(FeeQuery query);

    List<String> queryByBeneficiary(FeeQuery query);

    List<String> queryByPayer(FeeQuery query);

    Integer queryCount(FeeQuery query);
}