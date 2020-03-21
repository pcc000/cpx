package com.project.cpx.controller;

import com.project.cpx.common.util.*;
import com.project.cpx.entity.ConfigEntity;
import com.project.cpx.entity.FeeEntity;
import com.project.cpx.entity.PurchaseEntity;
import com.project.cpx.entity.query.FeeQuery;
import com.project.cpx.entity.query.PurchaseQuery;
import com.project.cpx.service.FeeService;
import com.project.cpx.service.PurchaseService;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/export")
    public HttpEntity<byte[]> export(PurchaseQuery query, HttpServletResponse response) throws Exception{
        List<PurchaseEntity> querReulstList  = purchaseService.query(query);
        List<List<PurchaseEntity>> resultList = new ArrayList<>();
        resultList.add(querReulstList);
        Map<String, String> headMap = Constant.EXPORT_PURCHASE_MAP;
        ExcelUtil export = new ExcelUtil();
        byte[] bytes = export.export(resultList, PurchaseEntity.class, headMap);
        response.setContentType(ExcelUtil.RESPONSE_CONTENT_TYPE);
        response.addHeader("Content-Disposition", ExcelUtil.getResponseHeadValue(Constant.EXPORT_PURCHASE_NAME));
        return new HttpEntity<>(bytes);
    }
}
