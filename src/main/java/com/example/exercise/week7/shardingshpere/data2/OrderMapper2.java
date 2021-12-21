package com.example.exercise.week7.shardingshpere.data2;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface OrderMapper2 {
    int deleteByPrimaryKey(Long id);

    int insert(MyOrder2 record);

    int insertSelective(MyOrder2 record);

    MyOrder2 selectByPrimaryKey(@Param("id") Long id);

    int updateByPrimaryKeySelective(MyOrder2 record);

    int updateByPrimaryKey(MyOrder2 record);
}