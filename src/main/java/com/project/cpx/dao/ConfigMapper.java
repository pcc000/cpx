package com.project.cpx.dao;

import com.project.cpx.entity.ConfigEntity;

import java.util.List;

public interface ConfigMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ConfigEntity record);

    int insertSelective(ConfigEntity record);

    ConfigEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ConfigEntity record);

    int updateByPrimaryKey(ConfigEntity record);

    List<ConfigEntity> query(ConfigEntity record);
}