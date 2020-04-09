package com.project.cpx.service.impl;

import com.project.cpx.common.util.CpxException;
import com.project.cpx.common.util.ErrorEnum;
import com.project.cpx.dao.MemberMapper;
import com.project.cpx.dao.MemberRightMapper;
import com.project.cpx.entity.CommonBuilder;
import com.project.cpx.entity.MemberEntity;
import com.project.cpx.entity.MemberRightEntity;
import com.project.cpx.entity.query.MemberRightQuery;
import com.project.cpx.service.MemberRightService;
import com.project.cpx.service.MemberService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

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

    @Resource
    private MemberMapper memberMapper;

    @Override
    public int add(MemberEntity entity) {
        MemberEntity result = memberMapper.selectByPrimaryKey(entity.getId());
        if(null != result ){
            if(!CollectionUtils.isEmpty(entity.getRights())){
                entity.getRights().forEach(rightEntity->{
                    if(null == rightEntity.getNum() || StringUtils.isEmpty(rightEntity.getRightContent())){
                        throw new CpxException(ErrorEnum.PARAM.getCode(),String.format(ErrorEnum.PARAM.getMsg(),"权益或数量不能为空"));
                    }
                    rightEntity.setMemberId(entity.getId());
                    memberRightMapper.insertSelective(rightEntity);
                });
            }
        }
        return result.getId();
    }

    @Override
    public int update(MemberEntity entity) {
        MemberEntity result = memberMapper.selectByPrimaryKey(entity.getId());
        if(null != result ){
            int updateResult = memberRightMapper.updateByMemberId(entity.getId());
            if(updateResult>0 && !CollectionUtils.isEmpty(entity.getRights())){
                entity.getRights().forEach(rightEntity->{
                    if(null == rightEntity.getNum() || StringUtils.isEmpty(rightEntity.getRightContent())){
                        throw new CpxException(ErrorEnum.PARAM.getCode(),String.format(ErrorEnum.PARAM.getMsg(),"权益或数量不能为空"));
                    }
                    rightEntity.setMemberId(entity.getId());
                    memberRightMapper.insertSelective(rightEntity);
                });
            }
        }
        return result.getId();
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
