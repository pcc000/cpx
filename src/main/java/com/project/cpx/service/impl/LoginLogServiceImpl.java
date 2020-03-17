package com.project.cpx.service.impl;

import com.project.cpx.dao.LoginLogMapper;
import com.project.cpx.entity.LoginLogEntity;
import com.project.cpx.service.LoginLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: shuyiwei
 * @Date: 2020/3/16 21:27
 * @Description:
 */
@Service
public class LoginLogServiceImpl implements LoginLogService {

    @Resource
    private LoginLogMapper loginLogMapper;

    @Override
    public int add(LoginLogEntity entity) {
        return loginLogMapper.insertSelective(entity);
    }

    @Override
    public int update(LoginLogEntity entity) {
        return loginLogMapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public int deleteById(Integer id) {
        return loginLogMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<LoginLogEntity> query(LoginLogEntity query) {
        return loginLogMapper.query(query);
    }
}
