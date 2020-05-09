package com.project.cpx.controller;

import com.project.cpx.common.util.*;
import com.project.cpx.entity.OperationEntity;
import com.project.cpx.entity.dto.ProfitDTO;
import com.project.cpx.entity.query.InventoryQuery;
import com.project.cpx.entity.query.OperationQuery;
import com.project.cpx.service.OperationService;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;

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
        query.setStart(null != query.getStart() ? query.getStart().replace(" 00:00:00","") : null);
        query.setEnd(null != query.getEnd() ? query.getEnd().replace(" 00:00:00","").replace(" 23:59:59","") : null);
        return Response.ok(operationService.query(query),query);
    }

    @RequestMapping(value = "/queryByDate",method = RequestMethod.GET)
    @ResponseBody
    public Response<List<ProfitDTO>> queryByDate(OperationQuery query){
        return Response.ok(operationService.queryByDate(query),query);
    }

    @GetMapping("/export")
    public HttpEntity<byte[]> export(OperationQuery query, HttpServletResponse response) throws Exception{
        List<OperationEntity> querReulstList  = operationService.query(query);
        List<List<OperationEntity>> resultList = new ArrayList<>();
        resultList.add(querReulstList);
        Map<String, String> headMap = Constant.EXPORT_OPERATION_MAP;
        ExcelUtil export = new ExcelUtil();
        byte[] bytes = export.export(resultList, OperationEntity.class, headMap);
        response.setContentType(ExcelUtil.RESPONSE_CONTENT_TYPE);
        response.addHeader("Content-Disposition", ExcelUtil.getResponseHeadValue(Constant.EXPORT_OPERATION_NAME));
        return new HttpEntity<>(bytes);
    }

}
