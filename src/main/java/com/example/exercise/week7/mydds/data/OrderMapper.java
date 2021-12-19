package com.example.exercise.week7.mydds.data;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface OrderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MyOrder record);

    int insertSelective(MyOrder record);

    MyOrder selectByPrimaryKey(@Param("id") Long id);

    int updateByPrimaryKeySelective(MyOrder record);

    int updateByPrimaryKey(MyOrder record);
}