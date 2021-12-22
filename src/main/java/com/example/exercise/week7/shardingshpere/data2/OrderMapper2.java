package com.example.exercise.week7.shardingshpere.data2;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

//@Mapper 使用@Mapper标注某个具体mapper类或者使用MapperScan在启动类标注包
@Component
public interface OrderMapper2 {
    int deleteByPrimaryKey(Long id);

    int insert(MyOrder2 record);

    int insertSelective(MyOrder2 record);

    MyOrder2 selectByPrimaryKey(@Param("id") Long id);

    int updateByPrimaryKeySelective(MyOrder2 record);

    int updateByPrimaryKey(MyOrder2 record);
}