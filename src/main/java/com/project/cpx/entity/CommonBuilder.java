package com.project.cpx.entity;

import com.project.cpx.entity.dto.FeeDTO;
import org.springframework.beans.BeanUtils;
import sun.security.krb5.Config;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @Auther: shuyiwei
 * @Date: 2020/2/29 23:03
 * @Description:
 */
public class CommonBuilder {

    public static UserEntity buildUserQuery(UserEntity userEntity){
        UserEntity result = new UserEntity();
        result.setUserName(userEntity.getUserName());
        return result;
    }

    public static ConfigEntity buildConfigQuery(ConfigEntity entity){
        ConfigEntity result = new ConfigEntity();
        result.setType(entity.getType());
        result.setKey(entity.getKey());
        return result;
    }

    public static FeeEntity buildFeeEntity(FeeDTO dto){
        FeeEntity feeEntity = new FeeEntity();
        feeEntity.setOperateDate(new SimpleDateFormat("yyyyMMdd").format(new Date()));
        feeEntity.setPayAmount(dto.getPayAmount());
        BeanUtils.copyProperties(dto,feeEntity);
        return feeEntity;
    }

    public static LoginLogEntity buildLoginLog(UserEntity userEntity){
        LoginLogEntity loginLogEntity = new LoginLogEntity();
        loginLogEntity.setUserName(userEntity.getUserName());
        loginLogEntity.setSessionId(UUID.randomUUID().toString());
        return loginLogEntity;
    }

    public static LoginLogEntity buildLoginQuery(String sessionId){
        LoginLogEntity loginLogEntity = new LoginLogEntity();
        loginLogEntity.setSessionId(sessionId);
        return loginLogEntity;
    }
}
