package com.gavin.seckill.mapper;

import com.gavin.seckill.dto.SecSucess;

public interface SecSucessMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SecSucess record);

    int insertSelective(SecSucess record);

    SecSucess selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SecSucess record);

    int updateByPrimaryKey(SecSucess record);
}