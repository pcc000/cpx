package com.project.cpx.service.impl;

import com.project.cpx.dao.MemberRightMapper;
import com.project.cpx.entity.MemberEntity;
import com.project.cpx.entity.MemberRightEntity;
import com.project.cpx.entity.query.MemberRightQuery;
import com.project.cpx.service.MemberRightService;
import com.project.cpx.service.MemberService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: shuyiwei
 * @Date: 2020/3/17 20:00
 * @Description:
 */
@Service
public class MemberRightServiceImpl implements MemberRightService {

    @Resource
    private MemberRightMapper memberRightMapper;

    @Override
    public int add(MemberRightEntity entity) {
        return memberRightMapper.insertSelective(entity);
    }

    @Override
    public int update(MemberRightEntity entity) {
        return memberRightMapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public int deleteById(Integer id) {
        return memberRightMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<MemberRightEntity> query(MemberRightQuery query) {
        List<MemberRightEntity> resultList = memberRightMapper.query(query);
        if(CollectionUtils.isEmpty(resultList)){
            return new ArrayList<>();
        }
        if(null == query.getTotalRecored()){
            Integer count = memberRightMapper.queryCount(query);
            query.setTotalRecored(count);
        }
        return  resultList;
    }
}
