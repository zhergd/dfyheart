package com.dfy.heart.dao;

import com.dfy.heart.domain.entity.HeartAccess;
import com.dfy.heart.domain.entity.HeartAccessExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javax.annotation.Resource;

@Resource
public interface HeartAccessMapper {
    long countByExample(HeartAccessExample example);

    int deleteByExample(HeartAccessExample example);

    int deleteByPrimaryKey(Integer accessId);

    int insert(HeartAccess record);

    int insertSelective(HeartAccess record);

    List<HeartAccess> selectByExample(HeartAccessExample example);

    HeartAccess selectByPrimaryKey(Integer accessId);

    int updateByExampleSelective(@Param("record") HeartAccess record, @Param("example") HeartAccessExample example);

    int updateByExample(@Param("record") HeartAccess record, @Param("example") HeartAccessExample example);

    int updateByPrimaryKeySelective(HeartAccess record);

    int updateByPrimaryKey(HeartAccess record);
}