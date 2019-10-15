package com.gavin.provider.mapper;

import com.gavin.provider.dto.SeckillInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SeckillInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SeckillInfo record);

    int insertSelective(SeckillInfo record);

    SeckillInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SeckillInfo record);

    int updateByPrimaryKey(SeckillInfo record);

    List<SeckillInfo> selectAll(@Param("start") int start, @Param("offset") int offset);

    //查询所有信息,给redis做缓存处理
    List<SeckillInfo> selectAllForCache();

    SeckillInfo selectById(@Param("id") Long id);


    Long selectInventoryById(@Param("id") Long id);

    //减库存

    int subInventoryById(@Param("id") Long id);

    //加库存

    int addInventoryById(@Param("id") Long id);


    Long countAll();



}