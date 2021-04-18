package com.dfy.heart.dao;

import com.dfy.heart.domain.entity.HeartUser;
import com.dfy.heart.domain.entity.HeartUserExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javax.annotation.Resource;

@Resource
public interface HeartUserMapper {
    long countByExample(HeartUserExample example);

    int deleteByExample(HeartUserExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(HeartUser record);

    int insertSelective(HeartUser record);

    List<HeartUser> selectByExample(HeartUserExample example);

    HeartUser selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") HeartUser record, @Param("example") HeartUserExample example);

    int updateByExample(@Param("record") HeartUser record, @Param("example") HeartUserExample example);

    int updateByPrimaryKeySelective(HeartUser record);

    int updateByPrimaryKey(HeartUser record);
}