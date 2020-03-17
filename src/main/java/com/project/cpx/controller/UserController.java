package com.project.cpx.controller;

import com.project.cpx.common.util.CheckCondition;
import com.project.cpx.common.util.ErrorEnum;
import com.project.cpx.common.util.Response;
import com.project.cpx.entity.CommonBuilder;
import com.project.cpx.entity.LoginLogEntity;
import com.project.cpx.entity.UserEntity;
import com.project.cpx.service.LoginLogService;
import com.project.cpx.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: shuyiwei
 * @Date: 2020/2/29 22:22
 * @Description:
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private LoginLogService loginLogService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public Response<Integer> add(@RequestBody UserEntity userEntity){
        CheckCondition.checkArgument(!StringUtils.isEmpty(userEntity.getUserName()), ErrorEnum.PARAM.getCode(),"用户姓名");
        CheckCondition.checkArgument(!StringUtils.isEmpty(userEntity.getPassword()), ErrorEnum.PARAM.getCode(),"密码");
        CheckCondition.checkArgument(!StringUtils.isEmpty(userEntity.getShopNo()), ErrorEnum.PARAM.getCode(),"店铺");
        UserEntity userQuery = CommonBuilder.buildUserQuery(userEntity);
        List<UserEntity> resultQueryList = userService.query(userQuery);
        if(!CollectionUtils.isEmpty(resultQueryList)){
            return Response.fail(ErrorEnum.USER_IS_EXIST);
        }else{
            return Response.ok(userService.add(userEntity));
        }
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public Response<Integer> update(@RequestBody UserEntity userEntity){
        CheckCondition.checkArgument(!StringUtils.isEmpty(userEntity.getUserName()), ErrorEnum.PARAM.getCode(),"用户姓名");
        CheckCondition.checkArgument(!StringUtils.isEmpty(userEntity.getPassword()), ErrorEnum.PARAM.getCode(),"密码");
        CheckCondition.checkArgument(!StringUtils.isEmpty(userEntity.getId()), ErrorEnum.PARAM.getCode(),"id");
        return Response.ok(userService.update(userEntity));
    }


    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public Response<Integer> delete(@RequestBody UserEntity userEntity){
        CheckCondition.checkArgument(!StringUtils.isEmpty(userEntity.getId()), ErrorEnum.PARAM.getCode(),"id");
        return Response.ok(userService.deleteById(userEntity.getId()));
    }

    @RequestMapping(value = "/query",method = RequestMethod.GET)
    @ResponseBody
    public Response<List<UserEntity>> query(UserEntity userEntity){
        List<UserEntity> resultQueryList = userService.query(userEntity);
        if(null!=resultQueryList){
            resultQueryList.forEach(entity->{
                entity.setPassword("**********");
            });
            return Response.ok(resultQueryList);
        }else{
            return Response.ok(null);
        }
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Response<List<UserEntity>> login(@RequestBody UserEntity userEntity){
        List<UserEntity> resultQueryList = userService.query(userEntity);
        if(CollectionUtils.isEmpty(resultQueryList)){
            return Response.fail(ErrorEnum.USER_OR_PASSWORD_IS_NOT_RIGHT);
        }
        LoginLogEntity loginLogEntity = CommonBuilder.buildLoginLog(userEntity);
        loginLogService.add(loginLogEntity);
        return Response.ok(loginLogEntity);
    }
}
