package com.project.cpx.controller;

import com.project.cpx.common.util.*;
import com.project.cpx.entity.InventoryEntity;
import com.project.cpx.entity.InventoryLogEntity;
import com.project.cpx.entity.PurchaseEntity;
import com.project.cpx.entity.query.FeeQuery;
import com.project.cpx.entity.query.InventoryLogQuery;
import com.project.cpx.entity.query.InventoryQuery;
import com.project.cpx.entity.query.PurchaseQuery;
import com.project.cpx.service.InventoryService;
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
 * @Date: 2020/3/3 19:17
 * @Description:
 */
@Controller
@RequestMapping(value = "/inventory")
public class InventoryController {

    @Resource
    private InventoryService inventoryService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public Response<Integer> add(@RequestBody InventoryEntity entity){
        entity.setOperateDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        return Response.ok(inventoryService.add(entity));
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public Response<Integer> update(@RequestBody InventoryEntity entity){
        CheckCondition.checkArgument(!StringUtils.isEmpty(entity.getId()), ErrorEnum.PARAM.getCode(),"id");
        return Response.ok(inventoryService.update(entity));
    }


    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public Response<Integer> delete(@RequestBody InventoryEntity entity){
        CheckCondition.checkArgument(!StringUtils.isEmpty(entity.getId()), ErrorEnum.PARAM.getCode(),"id");
        return Response.ok(inventoryService.deleteById(entity.getId()));
    }

    @RequestMapping(value = "/query",method = RequestMethod.GET)
    @ResponseBody
    public Response<List<InventoryEntity>> query(InventoryQuery query){
        return Response.ok(inventoryService.query(query),query);
    }

    @RequestMapping(value = "/addLog",method = RequestMethod.POST)
    @ResponseBody
    public Response<Integer> addLog(@RequestBody InventoryLogEntity entity){
        entity.setOperateDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        return Response.ok(inventoryService.add(entity));
    }

    @RequestMapping(value = "/updateLog",method = RequestMethod.POST)
    @ResponseBody
    public Response<Integer> update(@RequestBody InventoryLogEntity entity){
        CheckCondition.checkArgument(!StringUtils.isEmpty(entity.getId()), ErrorEnum.PARAM.getCode(),"id");
        return Response.ok(inventoryService.update(entity));
    }


    @RequestMapping(value = "/deleteLog",method = RequestMethod.POST)
    @ResponseBody
    public Response<Integer> delete(@RequestBody InventoryLogEntity entity){
        CheckCondition.checkArgument(!StringUtils.isEmpty(entity.getId()), ErrorEnum.PARAM.getCode(),"id");
        return Response.ok(inventoryService.deleteById(entity.getId()));
    }

    @RequestMapping(value = "/queryLog",method = RequestMethod.GET)
    @ResponseBody
    public Response<List<InventoryLogEntity>> query(InventoryLogQuery query){
        return Response.ok(inventoryService.query(query),query);
    }

    @GetMapping("/export")
    public HttpEntity<byte[]> export(InventoryQuery query, HttpServletResponse response) throws Exception{
        List<InventoryEntity> querReulstList  = inventoryService.query(query);
        List<List<InventoryEntity>> resultList = new ArrayList<>();
        resultList.add(querReulstList);
        Map<String, String> headMap = Constant.EXPORT_INVENTORY_MAP;
        ExcelUtil export = new ExcelUtil();
        byte[] bytes = export.export(resultList, InventoryEntity.class, headMap);
        response.setContentType(ExcelUtil.RESPONSE_CONTENT_TYPE);
        response.addHeader("Content-Disposition", ExcelUtil.getResponseHeadValue(Constant.EXPORT_INVENTORY_NAME));
        return new HttpEntity<>(bytes);
    }

}
