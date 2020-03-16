package com.project.cpx.service.impl;

import com.project.cpx.dao.PartnerCompanyMapper;
import com.project.cpx.entity.OperationEntity;
import com.project.cpx.entity.PartnerCompanyEntity;
import com.project.cpx.entity.query.PartnerCompanyQuery;
import com.project.cpx.service.PartnerCompanyService;
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
public class PartnerCompanyServiceImpl implements PartnerCompanyService {

    @Resource
    private PartnerCompanyMapper partnerCompanyMapper;

    @Override
    public int add(PartnerCompanyEntity entity) {
        return partnerCompanyMapper.insertSelective(entity);
    }

    @Override
    public int update(PartnerCompanyEntity entity) {
        return partnerCompanyMapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public int deleteById(Integer id) {
        return partnerCompanyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<PartnerCompanyEntity> query(PartnerCompanyQuery query) {
        List<PartnerCompanyEntity> resultList = partnerCompanyMapper.query(query);
        if(CollectionUtils.isEmpty(resultList)){
            return new ArrayList<>();
        }
        if(null == query.getTotalRecored()){
            Integer count = partnerCompanyMapper.queryCount(query);
            query.setTotalRecored(count);
        }
        return  resultList;
    }
}
