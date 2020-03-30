package com.project.cpx.dao;

import com.project.cpx.entity.OperationEntity;
import com.project.cpx.entity.dto.ProfitDTO;
import com.project.cpx.entity.query.OperationQuery;

import java.util.List;

public interface OperationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OperationEntity record);

    int insertSelective(OperationEntity record);

    OperationEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OperationEntity record);

    int updateByPrimaryKey(OperationEntity record);

    List<OperationEntity> query(OperationQuery query);

    Integer queryCount(OperationQuery query);

    List<ProfitDTO> queryByDate(OperationQuery query);
}