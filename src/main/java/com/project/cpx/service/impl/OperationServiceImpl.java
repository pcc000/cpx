package com.project.cpx.service.impl;

import com.project.cpx.common.util.DateUtil;
import com.project.cpx.dao.OperationMapper;
import com.project.cpx.entity.CommonBuilder;
import com.project.cpx.entity.InventoryEntity;
import com.project.cpx.entity.InventoryLogEntity;
import com.project.cpx.entity.OperationEntity;
import com.project.cpx.entity.dto.ProfitDTO;
import com.project.cpx.entity.query.OperationQuery;
import com.project.cpx.service.InventoryService;
import com.project.cpx.service.OperationService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

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

    @Resource
    private InventoryService inventoryService;

    @Override
    public int add(OperationEntity entity) {
        Integer result = operationMapper.insertSelective(entity);
        if(result > 0){
            InventoryEntity inventoryEntity = CommonBuilder.buildInventoyByOperation(entity);
            inventoryService.reduceInventory(inventoryEntity);
        }
        return result;
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

    @Override
    public List<ProfitDTO> queryByDate(OperationQuery query) {
        if(null != query && StringUtils.isEmpty(query.getStart()) && StringUtils.isEmpty(query.getEnd())){
            query.setStart(DateUtil.getMonthFirstDay()+" 00:00:00");
            query.setEnd(DateUtil.getMonthLastDay()+" 23:59:59");
        }
        List<ProfitDTO> resultList = operationMapper.queryByDate(query);
        if(CollectionUtils.isEmpty(resultList)){
            return new ArrayList<>();
        }
        if(null == query.getTotalRecored()){
            query.setTotalRecored(resultList.size());
        }
        return resultList;
    }
}
