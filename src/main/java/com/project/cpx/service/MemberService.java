package com.project.cpx.service;

import com.project.cpx.entity.MemberEntity;
import com.project.cpx.entity.query.MemberQuery;

import java.util.List;

/**
 * @Auther: shuyiwei
 * @Date: 2020/3/16 21:07
 * @Description:
 */
public interface MemberService {

    int add(MemberEntity feeEntity);

    int update(MemberEntity feeEntity);

    int deleteById(Integer id);

    List<MemberEntity> query(MemberQuery query);
}
