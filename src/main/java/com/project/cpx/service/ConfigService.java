package com.project.cpx.service;

import com.project.cpx.entity.ConfigEntity;
import com.project.cpx.entity.UserEntity;

import java.util.List;

/**
 * @Auther: shuyiwei
 * @Date: 2020/3/1 12:08
 * @Description:
 */
public interface ConfigService {

    int add(ConfigEntity configEntity);

    int update(ConfigEntity configEntity);

    int deleteById(Integer id);

    List<ConfigEntity> query(ConfigEntity configEntity);

}
