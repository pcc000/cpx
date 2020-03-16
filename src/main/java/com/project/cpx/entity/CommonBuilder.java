package com.project.cpx.entity;

import com.project.cpx.entity.dto.FeeDTO;
import org.springframework.beans.BeanUtils;
import sun.security.krb5.Config;

import java.text.SimpleDateFormat;
import java.util.Date;

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
        Double amount = dto.getPayAmount()*100;
        feeEntity.setPayAmount(amount.intValue());
        BeanUtils.copyProperties(dto,feeEntity);
        return feeEntity;
    }
}
