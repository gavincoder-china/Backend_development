package com.gavin.seckill.mapper;

import com.gavin.seckill.dto.SeckillInfo;

public interface SeckillInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SeckillInfo record);

    int insertSelective(SeckillInfo record);

    SeckillInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SeckillInfo record);

    int updateByPrimaryKey(SeckillInfo record);
}