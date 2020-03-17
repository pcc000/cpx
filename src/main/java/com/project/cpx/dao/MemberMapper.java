package com.project.cpx.dao;

import com.project.cpx.entity.MemberEntity;
import com.project.cpx.entity.query.MemberQuery;

import java.util.List;

public interface MemberMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MemberEntity record);

    int insertSelective(MemberEntity record);

    MemberEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MemberEntity record);

    int updateByPrimaryKey(MemberEntity record);

    List<MemberEntity> query(MemberQuery query);

    Integer queryCount(MemberQuery query);
}