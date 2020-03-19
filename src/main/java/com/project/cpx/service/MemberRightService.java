package com.project.cpx.service;

import com.project.cpx.entity.MemberRightEntity;
import com.project.cpx.entity.query.MemberQuery;
import com.project.cpx.entity.query.MemberRightQuery;

import java.util.List;

/**
 * @Auther: shuyiwei
 * @Date: 2020/3/17 19:59
 * @Description:
 */
public interface MemberRightService {

    int add(MemberRightEntity entity);

    int update(MemberRightEntity entity);

    int deleteById(Integer id);

    List<MemberRightEntity> query(MemberRightQuery query);
}
