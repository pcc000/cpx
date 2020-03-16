package com.project.cpx.service.impl;

import com.project.cpx.dao.FeeMapper;
import com.project.cpx.entity.FeeEntity;
import com.project.cpx.entity.query.FeeQuery;
import com.project.cpx.service.FeeService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Auther: shuyiwei
 * @Date: 2020/3/1 19:03
 * @Description:
 */
@Service
public class FeeServiceImpl implements FeeService {

    @Resource
    private FeeMapper feeMapper;


    @Override
    public int add(FeeEntity feeEntity) {
        return feeMapper.insertSelective(feeEntity);
    }

    @Override
    public int update(FeeEntity feeEntity) {
        return feeMapper.updateByPrimaryKeySelective(feeEntity);
    }

    @Override
    public int deleteById(Integer id) {
        return feeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<FeeEntity> query(FeeQuery query) {
        List<FeeEntity> resultList = feeMapper.query(query);
        if(CollectionUtils.isEmpty(resultList)){
            return new ArrayList<>();
        }
        if(null == query.getTotalRecored()){
            Integer count = feeMapper.queryCount(query);
            query.setTotalRecored(count);
        }
        return  resultList;
    }

    @Override
    public List<String> queryByOperateThing(FeeQuery query) {
        return feeMapper.queryByOperateThing(query);
    }

    @Override
    public List<String> queryByBeneficiary(FeeQuery query) {
        return feeMapper.queryByBeneficiary(query);
    }

    @Override
    public List<String> queryByPayer(FeeQuery query) {
        return feeMapper.queryByPayer(query);
    }
}
