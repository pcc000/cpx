package com.project.cpx.controller;

import com.project.cpx.common.util.CheckCondition;
import com.project.cpx.common.util.ErrorEnum;
import com.project.cpx.common.util.Response;
import com.project.cpx.entity.MemberEntity;
import com.project.cpx.entity.query.InventoryQuery;
import com.project.cpx.entity.query.MemberQuery;
import com.project.cpx.service.InventoryService;
import com.project.cpx.service.MemberService;
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
 * @Date: 2020/3/16 21:06
 * @Description:
 */
@Controller
@RequestMapping(value = "/member")
public class MemberController {

    @Resource
    private MemberService memberService;

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
}
