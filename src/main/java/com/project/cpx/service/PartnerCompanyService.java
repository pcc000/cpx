package com.project.cpx.service;

import com.project.cpx.entity.OperationEntity;
import com.project.cpx.entity.PartnerCompanyEntity;
import com.project.cpx.entity.query.PartnerCompanyQuery;

import java.util.List;

/**
 * @Auther: shuyiwei
 * @Date: 2020/3/3 19:18
 * @Description:
 */
public interface PartnerCompanyService {

    int add(PartnerCompanyEntity entity);

    int update(PartnerCompanyEntity entity);

    int deleteById(Integer id);

    List<PartnerCompanyEntity> query(PartnerCompanyQuery query);
}
