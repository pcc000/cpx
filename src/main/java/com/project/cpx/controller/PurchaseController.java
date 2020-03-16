package com.project.cpx.controller;

import com.project.cpx.common.util.CheckCondition;
import com.project.cpx.common.util.ErrorEnum;
import com.project.cpx.common.util.Response;
import com.project.cpx.entity.ConfigEntity;
import com.project.cpx.entity.FeeEntity;
import com.project.cpx.entity.PurchaseEntity;
import com.project.cpx.entity.query.FeeQuery;
import com.project.cpx.entity.query.PurchaseQuery;
import com.project.cpx.service.FeeService;
import com.project.cpx.service.PurchaseService;
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
 * @Date: 2020/3/1 21:10
 * @Description:
 */
@Controller
@RequestMapping(value = "/purchase")
public class PurchaseController {

    @Resource
    private PurchaseService purchaseService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public Response<Integer> add(@RequestBody PurchaseEntity entity){
        entity.setOperateDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        return Response.ok(purchaseService.add(entity));
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public Response<Integer> update(@RequestBody PurchaseEntity entity){
        CheckCondition.checkArgument(!StringUtils.isEmpty(entity.getId()), ErrorEnum.PARAM.getCode(),"id");
        return Response.ok(purchaseService.update(entity));
    }


    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public Response<Integer> delete(@RequestBody PurchaseEntity entity){
        CheckCondition.checkArgument(!StringUtils.isEmpty(entity.getId()), ErrorEnum.PARAM.getCode(),"id");
        return Response.ok(purchaseService.deleteById(entity.getId()));
    }

    @RequestMapping(value = "/query",method = RequestMethod.GET)
    @ResponseBody
    public Response<List<PurchaseEntity>> query(PurchaseQuery entity){
        return Response.ok(purchaseService.query(entity),entity);
    }

    @RequestMapping(value = "/queryByProductName",method = RequestMethod.GET)
    @ResponseBody
    public Response<List<String>> queryByProductName(PurchaseQuery entity){
        return Response.ok(purchaseService.queryByProductName(entity));
    }

    @RequestMapping(value = "/queryByCarType",method = RequestMethod.GET)
    @ResponseBody
    public Response<List<String>> queryByCarType(PurchaseQuery entity){
        return Response.ok(purchaseService.queryByCarType(entity));
    }

    @RequestMapping(value = "/queryByManager",method = RequestMethod.GET)
    @ResponseBody
    public Response<List<String>> queryByManager(PurchaseQuery entity){
        return Response.ok(purchaseService.queryByManager(entity));
    }

    @RequestMapping(value = "/queryBySupplierCompanyName",method = RequestMethod.GET)
    @ResponseBody
    public Response<List<PurchaseEntity>> queryBySupplierCompanyName(PurchaseQuery entity){
        return Response.ok(purchaseService.queryBySupplierCompanyName(entity));
    }
}
