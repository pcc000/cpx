package com.project.cpx.controller;

import com.project.cpx.common.util.*;
import com.project.cpx.entity.InventoryEntity;
import com.project.cpx.entity.MemberEntity;
import com.project.cpx.entity.MemberRightEntity;
import com.project.cpx.entity.query.InventoryQuery;
import com.project.cpx.entity.query.MemberQuery;
import com.project.cpx.entity.query.MemberRightQuery;
import com.project.cpx.service.MemberRightService;
import com.project.cpx.service.MemberService;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Auther: shuyiwei
 * @Date: 2020/3/16 21:06
 * @Description:
 */
@Controller
@RequestMapping(value = "/member")
public class MemberController {

    @Resource
    private MemberService memberService;

    @Resource
    private MemberRightService memberRightService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public Response<Integer> add(@RequestBody MemberEntity entity){
        return Response.ok(memberService.add(entity));
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public Response<Integer> update(@RequestBody MemberEntity entity){
        CheckCondition.checkArgument(!StringUtils.isEmpty(entity.getId()), ErrorEnum.PARAM.getCode(),"id");
        return Response.ok(memberService.update(entity));
    }


    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public Response<Integer> delete(@RequestBody MemberEntity entity){
        CheckCondition.checkArgument(!StringUtils.isEmpty(entity.getId()), ErrorEnum.PARAM.getCode(),"id");
        return Response.ok(memberService.deleteById(entity.getId()));
    }

    @RequestMapping(value = "/query",method = RequestMethod.GET)
    @ResponseBody
    public Response<List<MemberEntity>> query(MemberQuery query){
        return Response.ok(memberService.query(query),query);
    }

    @RequestMapping(value = "/addMemberRight",method = RequestMethod.POST)
    @ResponseBody
    public Response<Integer> addMemberRight(@RequestBody MemberEntity entity){
        return Response.ok(memberRightService.add(entity));
    }

    @RequestMapping(value = "/updateMemberRight",method = RequestMethod.POST)
    @ResponseBody
    public Response<Integer> updateMemberRight(@RequestBody MemberEntity entity){
        CheckCondition.checkArgument(!StringUtils.isEmpty(entity.getId()), ErrorEnum.PARAM.getCode(),"id");
        return Response.ok(memberRightService.update(entity));
    }


    @RequestMapping(value = "/deleteMemberRight",method = RequestMethod.POST)
    @ResponseBody
    public Response<Integer> deleteMemberRight(@RequestBody MemberRightEntity entity){
        CheckCondition.checkArgument(!StringUtils.isEmpty(entity.getId()), ErrorEnum.PARAM.getCode(),"id");
        return Response.ok(memberRightService.deleteById(entity.getId()));
    }

    @RequestMapping(value = "/queryMemberRight",method = RequestMethod.GET)
    @ResponseBody
    public Response<List<MemberRightEntity>> queryMemberRight(MemberRightQuery query){
        return Response.ok(memberRightService.query(query),query);
    }

    @GetMapping("/export")
    public HttpEntity<byte[]> export(MemberQuery query, HttpServletResponse response) throws Exception{
        List<MemberEntity> querReulstList  = memberService.query(query);
        List<List<MemberEntity>> resultList = new ArrayList<>();
        resultList.add(querReulstList);
        Map<String, String> headMap = Constant.EXPORT_MEMBER_MAP;
        ExcelUtil export = new ExcelUtil();
        byte[] bytes = export.export(resultList, MemberEntity.class, headMap);
        response.setContentType(ExcelUtil.RESPONSE_CONTENT_TYPE);
        response.addHeader("Content-Disposition", ExcelUtil.getResponseHeadValue(Constant.EXPORT_MEMBER_NAME));
        return new HttpEntity<>(bytes);
    }
}
