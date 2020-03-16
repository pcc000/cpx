package com.project.cpx.service;

import com.project.cpx.entity.UserEntity;

import java.util.List;

/**
 * @Auther: shuyiwei
 * @Date: 2020/2/29 22:23
 * @Description:
 */
public interface UserService {

    int add(UserEntity userEntity);

    int update(UserEntity userEntity);

    int deleteById(Integer id);

    List<UserEntity> query(UserEntity userEntity);
}
