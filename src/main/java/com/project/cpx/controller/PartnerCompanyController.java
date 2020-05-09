package com.project.cpx.controller;

import com.project.cpx.common.util.CheckCondition;
import com.project.cpx.common.util.ErrorEnum;
import com.project.cpx.common.util.Response;
import com.project.cpx.entity.PartnerCompanyEntity;
import com.project.cpx.entity.query.OperationQuery;
import com.project.cpx.entity.query.PartnerCompanyQuery;
import com.project.cpx.service.PartnerCompanyService;
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
@RequestMapping(value = "/partnerCompany")
public class PartnerCompanyController {

    @Resource
    private PartnerCompanyService partnerCompanyService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public Response<Integer> add(@RequestBody PartnerCompanyEntity entity){
        return Response.ok(partnerCompanyService.add(entity));
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public Response<Integer> update(@RequestBody PartnerCompanyEntity entity){
        CheckCondition.checkArgument(!StringUtils.isEmpty(entity.getId()), ErrorEnum.PARAM.getCode(),"id");
        return Response.ok(partnerCompanyService.update(entity));
    }


    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public Response<Integer> delete(@RequestBody PartnerCompanyEntity entity){
        CheckCondition.checkArgument(!StringUtils.isEmpty(entity.getId()), ErrorEnum.PARAM.getCode(),"id");
        return Response.ok(partnerCompanyService.deleteById(entity.getId()));
    }

    @RequestMapping(value = "/query",method = RequestMethod.GET)
    @ResponseBody
    public Response<List<PartnerCompanyEntity>> query(PartnerCompanyQuery query){
        query.setStart(null != query.getStart() ? query.getStart().replace(" 00:00:00","") : null);
        query.setEnd(null != query.getEnd() ? query.getEnd().replace(" 00:00:00","").replace(" 23:59:59","") : null);
        return Response.ok(partnerCompanyService.query(query),query);
    }
}
