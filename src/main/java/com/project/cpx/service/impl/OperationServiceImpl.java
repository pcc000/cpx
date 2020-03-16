package com.project.cpx.service.impl;

import com.project.cpx.dao.OperationMapper;
import com.project.cpx.entity.InventoryLogEntity;
import com.project.cpx.entity.OperationEntity;
import com.project.cpx.entity.query.OperationQuery;
import com.project.cpx.service.OperationService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: shuyiwei
 * @Date: 2020/3/3 19:20
 * @Description:
 */
@Service
public class OperationServiceImpl implements OperationService {

    @Resource
    private OperationMapper operationMapper;

    @Override
    public int add(OperationEntity entity) {
        return operationMapper.insertSelective(entity);
    }

    @Override
    public int update(OperationEntity entity) {
        return operationMapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public int deleteById(Integer id) {
        return operationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<OperationEntity> query(OperationQuery query) {
        List<OperationEntity> resultList = operationMapper.query(query);
        if(CollectionUtils.isEmpty(resultList)){
            return new ArrayList<>();
        }
        if(null == query.getTotalRecored()){
            Integer count = operationMapper.queryCount(query);
            query.setTotalRecored(count);
        }
        return  resultList;
    }
}
