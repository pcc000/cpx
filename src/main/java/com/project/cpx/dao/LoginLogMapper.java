package com.project.cpx.dao;

import com.project.cpx.entity.LoginLogEntity;

import java.util.List;

public interface LoginLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LoginLogEntity record);

    int insertSelective(LoginLogEntity record);

    LoginLogEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LoginLogEntity record);

    int updateByPrimaryKey(LoginLogEntity record);

    List<LoginLogEntity> query(LoginLogEntity query);
}