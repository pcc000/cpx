package com.project.cpx.service.impl;

import com.project.cpx.dao.MemberMapper;
import com.project.cpx.entity.InventoryEntity;
import com.project.cpx.entity.MemberEntity;
import com.project.cpx.entity.query.MemberQuery;
import com.project.cpx.service.MemberService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: shuyiwei
 * @Date: 2020/3/16 21:08
 * @Description:
 */
@Service
public class MemberServiceImpl implements MemberService {

    @Resource
    private MemberMapper memberMapper;

    @Override
    public int add(MemberEntity entity) {
        return memberMapper.insertSelective(entity);
    }

    @Override
    public int update(MemberEntity entity) {
        return memberMapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public int deleteById(Integer id) {
        return memberMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<MemberEntity> query(MemberQuery query) {
        List<MemberEntity> resultList = memberMapper.query(query);
        if(CollectionUtils.isEmpty(resultList)){
            return new ArrayList<>();
        }
        if(null == query.getTotalRecored()){
            Integer count = memberMapper.queryCount(query);
            query.setTotalRecored(count);
        }
        return  resultList;
    }
}
