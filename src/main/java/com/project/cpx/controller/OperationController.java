package com.project.cpx.controller;

import com.project.cpx.common.util.CheckCondition;
import com.project.cpx.common.util.ErrorEnum;
import com.project.cpx.common.util.Response;
import com.project.cpx.entity.OperationEntity;
import com.project.cpx.entity.query.InventoryQuery;
import com.project.cpx.entity.query.OperationQuery;
import com.project.cpx.service.OperationService;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Auther: shuyiwei
 * @Date: 2020/3/3 19:17
 * @Description:
 */
@Controller
@RequestMapping(value = "/operation")
public class OperationController {

    @Resource
    private OperationService operationService;


    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public Response<Integer> add(@RequestBody OperationEntity entity){
        entity.setOperateDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        return Response.ok(operationService.add(entity));
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public Response<Integer> update(@RequestBody OperationEntity entity){
        CheckCondition.checkArgument(!StringUtils.isEmpty(entity.getId()), ErrorEnum.PARAM.getCode(),"id");
        return Response.ok(operationService.update(entity));
    }


    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public Response<Integer> delete(@RequestBody OperationEntity entity){
        CheckCondition.checkArgument(!StringUtils.isEmpty(entity.getId()), ErrorEnum.PARAM.getCode(),"id");
        return Response.ok(operationService.deleteById(entity.getId()));
    }

    @RequestMapping(value = "/query",method = RequestMethod.GET)
    @ResponseBody
    public Response<List<OperationEntity>> query(OperationQuery query){
        return Response.ok(operationService.query(query),query);
    }

}
