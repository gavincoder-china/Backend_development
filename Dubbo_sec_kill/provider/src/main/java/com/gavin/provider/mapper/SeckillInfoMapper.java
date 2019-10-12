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

    SeckillInfo selectById(@Param("id") Long id);


    Long selectInventoryById(@Param("id") Long id);

    //减库存
    int updateInventoryById(@Param("id") Long id);

    Long countAll();




}