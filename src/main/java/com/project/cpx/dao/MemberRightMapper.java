package com.project.cpx.dao;

import com.project.cpx.entity.MemberRightEntity;
import com.project.cpx.entity.query.MemberRightQuery;

import java.util.List;

public interface MemberRightMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MemberRightEntity record);

    int insertSelective(MemberRightEntity record);

    MemberRightEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MemberRightEntity record);

    int updateByPrimaryKey(MemberRightEntity record);

    List<MemberRightEntity> query(MemberRightQuery query);

    Integer queryCount(MemberRightQuery query);
}