package com.gavin.seckill.mapper;

import com.gavin.seckill.dto.UserOauth;

public interface UserOauthMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserOauth record);

    int insertSelective(UserOauth record);

    UserOauth selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserOauth record);

    int updateByPrimaryKey(UserOauth record);

}