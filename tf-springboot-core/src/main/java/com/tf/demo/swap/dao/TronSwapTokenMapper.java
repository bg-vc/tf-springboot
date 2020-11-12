package com.tf.demo.swap.dao;

import com.tf.demo.swap.model.TronSwapToken;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TronSwapTokenMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TronSwapToken record);

    int insertSelective(TronSwapToken record);

    TronSwapToken selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TronSwapToken record);

    int updateByPrimaryKey(TronSwapToken record);

    List<TronSwapToken> selectAll();
}

