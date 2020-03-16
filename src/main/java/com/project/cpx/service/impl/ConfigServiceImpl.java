package com.project.cpx.service.impl;

import com.project.cpx.dao.ConfigMapper;
import com.project.cpx.entity.ConfigEntity;
import com.project.cpx.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: shuyiwei
 * @Date: 2020/3/1 12:08
 * @Description:
 */
@Service
public class ConfigServiceImpl implements ConfigService {

    @Resource
    private ConfigMapper configMapper;

    @Override
    public int add(ConfigEntity configEntity) {
        return configMapper.insertSelective(configEntity);
    }

    @Override
    public int update(ConfigEntity configEntity) {
        return configMapper.updateByPrimaryKeySelective(configEntity);
    }

    @Override
    public int deleteById(Integer id) {
        return configMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<ConfigEntity> query(ConfigEntity configEntity) {
        return configMapper.query(configEntity);
    }
}
