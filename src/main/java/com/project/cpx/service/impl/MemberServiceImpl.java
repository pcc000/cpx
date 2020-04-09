package com.project.cpx.service.impl;

import com.project.cpx.common.util.DateUtil;
import com.project.cpx.dao.MemberMapper;
import com.project.cpx.dao.MemberRightMapper;
import com.project.cpx.entity.InventoryEntity;
import com.project.cpx.entity.MemberEntity;
import com.project.cpx.entity.MemberRightEntity;
import com.project.cpx.entity.query.MemberQuery;
import com.project.cpx.service.MemberService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Auther: shuyiwei
 * @Date: 2020/3/16 21:08
 * @Description:
 */
@Service
public class MemberServiceImpl implements MemberService {

    @Resource
    private MemberMapper memberMapper;

    @Resource
    private MemberRightMapper memberRightMapper;

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

        resultList.forEach(memberEntity -> {
            memberEntity.setGmtCreate(memberEntity.getGmtCreate().replace("T","").replace(".000+0000",""));
        });

        if(null == query.getTotalRecored()){
            Integer count = memberMapper.queryCount(query);
            query.setTotalRecored(count);
        }
        List<Integer> ids = resultList.stream().map(MemberEntity::getId).collect(Collectors.toList());
        List<MemberRightEntity> rightEntityList = memberRightMapper.queryByMemberId(ids);
        if(!CollectionUtils.isEmpty(rightEntityList)){
            Map<Integer,List<MemberRightEntity>> rightMap = rightEntityList.stream().collect(Collectors.groupingBy(MemberRightEntity::getMemberId));
            resultList.forEach(memberEntity -> {
                if(null != rightMap && null != rightMap.get(memberEntity.getId())){
                    memberEntity.setRights(rightMap.get(memberEntity.getId()));
                }
            });
        }
        return  resultList;
    }
}
