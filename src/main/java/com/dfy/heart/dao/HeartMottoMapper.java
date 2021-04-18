package com.dfy.heart.dao;

import com.dfy.heart.domain.entity.HeartMotto;
import com.dfy.heart.domain.entity.HeartMottoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javax.annotation.Resource;

@Resource
public interface HeartMottoMapper {
    long countByExample(HeartMottoExample example);

    int deleteByExample(HeartMottoExample example);

    int deleteByPrimaryKey(Integer mottoId);

    int insert(HeartMotto record);

    int insertSelective(HeartMotto record);

    List<HeartMotto> selectByExample(HeartMottoExample example);

    HeartMotto selectByPrimaryKey(Integer mottoId);

    int updateByExampleSelective(@Param("record") HeartMotto record, @Param("example") HeartMottoExample example);

    int updateByExample(@Param("record") HeartMotto record, @Param("example") HeartMottoExample example);

    int updateByPrimaryKeySelective(HeartMotto record);

    int updateByPrimaryKey(HeartMotto record);
}