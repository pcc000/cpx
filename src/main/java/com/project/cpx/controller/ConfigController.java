package com.project.cpx.controller;

import com.project.cpx.common.util.CheckCondition;
import com.project.cpx.common.util.ErrorEnum;
import com.project.cpx.common.util.Response;
import com.project.cpx.entity.CommonBuilder;
import com.project.cpx.entity.ConfigEntity;
import com.project.cpx.service.ConfigService;
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
 * @Date: 2020/3/1 12:08
 * @Description:
 */
@Controller
@RequestMapping("/config")
public class ConfigController {

    @Resource
    private ConfigService configService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public Response<Integer> add(@RequestBody ConfigEntity entity){
        CheckCondition.checkArgument(!StringUtils.isEmpty(entity.getType()), ErrorEnum.PARAM.getCode(),"type");
        CheckCondition.checkArgument(!StringUtils.isEmpty(entity.getKey()), ErrorEnum.PARAM.getCode(),"key");
        CheckCondition.checkArgument(!StringUtils.isEmpty(entity.getValue()), ErrorEnum.PARAM.getCode(),"value");
        ConfigEntity confgQuery = CommonBuilder.buildConfigQuery(entity);
        List<ConfigEntity> resultQueryList = configService.query(confgQuery);
        if(!CollectionUtils.isEmpty(resultQueryList)){
            return Response.fail(ErrorEnum.CONFIG_IS_EXIST);
        }else{
            return Response.ok(configService.add(entity));
        }
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public Response<Integer> update(@RequestBody ConfigEntity entity){
        CheckCondition.checkArgument(!StringUtils.isEmpty(entity.getType()), ErrorEnum.PARAM.getCode(),"type");
        CheckCondition.checkArgument(!StringUtils.isEmpty(entity.getKey()), ErrorEnum.PARAM.getCode(),"key");
        CheckCondition.checkArgument(!StringUtils.isEmpty(entity.getId()), ErrorEnum.PARAM.getCode(),"id");
        return Response.ok(configService.update(entity));
    }


    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public Response<Integer> delete(@RequestBody ConfigEntity entity){
        CheckCondition.checkArgument(!StringUtils.isEmpty(entity.getId()), ErrorEnum.PARAM.getCode(),"id");
        return Response.ok(configService.deleteById(entity.getId()));
    }

    @RequestMapping(value = "/query",method = RequestMethod.GET)
    @ResponseBody
    public Response<List<ConfigEntity>> query(ConfigEntity entity){
        return Response.ok(configService.query(entity));
    }
}
