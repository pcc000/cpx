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

    int add(MemberEntity entity);

    int update(MemberEntity entity);

    int deleteById(Integer id);

    List<MemberEntity> query(MemberQuery query);
}
