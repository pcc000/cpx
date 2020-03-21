package com.project.cpx.controller;

import com.project.cpx.common.util.*;
import com.project.cpx.entity.*;
import com.project.cpx.entity.dto.FeeDTO;
import com.project.cpx.entity.query.FeeQuery;
import com.project.cpx.entity.query.OperationQuery;
import com.project.cpx.service.FeeService;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
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
 * @Date: 2020/3/1 19:02
 * @Description:
 */
@Controller
@RequestMapping(value = "/fee")
public class FeeController {

    @Resource
    private FeeService feeService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public Response<Integer> add(@RequestBody FeeEntity entity){
//        FeeEntity entity = CommonBuilder.buildFeeEntity(dto);
        entity.setOperateDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        return Response.ok(feeService.add(entity));
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public Response<Integer> update(@RequestBody FeeEntity entity){
        CheckCondition.checkArgument(!StringUtils.isEmpty(entity.getId()), ErrorEnum.PARAM.getCode(),"id");
//        FeeEntity entity = CommonBuilder.buildFeeEntity(dto);
        return Response.ok(feeService.update(entity));
    }


    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public Response<Integer> delete(@RequestBody FeeEntity entity){
        CheckCondition.checkArgument(!StringUtils.isEmpty(entity.getId()), ErrorEnum.PARAM.getCode(),"id");
        return Response.ok(feeService.deleteById(entity.getId()));
    }

    @RequestMapping(value = "/query",method = RequestMethod.GET)
    @ResponseBody
    public Response<List<FeeEntity>> query(FeeQuery query){
        return Response.ok(feeService.query(query),query);
    }

    @RequestMapping(value = "/queryByOperateThing",method = RequestMethod.GET)
    @ResponseBody
    public Response<List<String>> queryByOperateThing(FeeQuery entity){
        return Response.ok(feeService.queryByOperateThing(entity));
    }

    @RequestMapping(value = "/queryByBeneficiary",method = RequestMethod.GET)
    @ResponseBody
    public Response<List<String>> queryByBeneficiary(FeeQuery entity){
        return Response.ok(feeService.queryByBeneficiary(entity));
    }

    @RequestMapping(value = "/queryByPayer",method = RequestMethod.GET)
    @ResponseBody
    public Response<List<String>> queryByPayer(FeeQuery entity){
        return Response.ok(feeService.queryByPayer(entity));
    }

    @GetMapping("/export")
    public HttpEntity<byte[]> export(FeeQuery query, HttpServletResponse response) throws Exception{
        List<FeeEntity> querReulstList  = feeService.query(query);
        List<List<FeeEntity>> resultList = new ArrayList<>();
        resultList.add(querReulstList);
        Map<String, String> headMap = Constant.EXPORT_FEE_MAP;
        ExcelUtil export = new ExcelUtil();
        byte[] bytes = export.export(resultList, FeeEntity.class, headMap);
        response.setContentType(ExcelUtil.RESPONSE_CONTENT_TYPE);
        response.addHeader("Content-Disposition", ExcelUtil.getResponseHeadValue(Constant.EXPORT_FEE_NAME));
        return new HttpEntity<>(bytes);
    }
}
