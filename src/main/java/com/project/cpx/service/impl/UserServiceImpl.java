package com.project.cpx.service.impl;

import com.project.cpx.dao.UserMapper;
import com.project.cpx.entity.UserEntity;
import com.project.cpx.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: shuyiwei
 * @Date: 2020/2/29 22:23
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public int add(UserEntity userEntity) {
        return userMapper.insertSelective(userEntity);
    }

    @Override
    public int update(UserEntity userEntity) {
        return userMapper.updateByPrimaryKeySelective(userEntity);
    }

    @Override
    public int deleteById(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<UserEntity> query(UserEntity userEntity) {
        return userMapper.query(userEntity);
    }
}
