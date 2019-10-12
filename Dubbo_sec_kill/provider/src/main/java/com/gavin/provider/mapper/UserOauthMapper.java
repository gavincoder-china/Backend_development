package com.gavin.provider.mapper;

import com.gavin.provider.dto.UserOauth;

public interface UserOauthMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserOauth record);

    int insertSelective(UserOauth record);

    UserOauth selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserOauth record);

    int updateByPrimaryKey(UserOauth record);

}