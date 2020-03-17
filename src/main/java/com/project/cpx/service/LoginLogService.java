package com.project.cpx.service;

import com.project.cpx.entity.LoginLogEntity;
import com.project.cpx.entity.MemberEntity;
import com.project.cpx.entity.query.MemberQuery;

import java.util.List;

/**
 * @Auther: shuyiwei
 * @Date: 2020/3/16 21:27
 * @Description:
 */
public interface LoginLogService {
    int add(LoginLogEntity entity);

    int update(LoginLogEntity entity);

    int deleteById(Integer id);

    List<LoginLogEntity> query(LoginLogEntity query);
}
