package com.project.cpx.dao;

import com.project.cpx.entity.PartnerCompanyEntity;
import com.project.cpx.entity.query.PartnerCompanyQuery;

import java.util.List;

public interface PartnerCompanyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PartnerCompanyEntity record);

    int insertSelective(PartnerCompanyEntity record);

    PartnerCompanyEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PartnerCompanyEntity record);

    int updateByPrimaryKey(PartnerCompanyEntity record);

    List<PartnerCompanyEntity> query(PartnerCompanyQuery query);

    Integer queryCount(PartnerCompanyQuery query);
}