package com.tf.test.dao;

import com.tf.test.model.TronSwapToken;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TronSwapTokenMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TronSwapToken record);

    int insertSelective(TronSwapToken record);

    TronSwapToken selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TronSwapToken record);

    int updateByPrimaryKey(TronSwapToken record);
}