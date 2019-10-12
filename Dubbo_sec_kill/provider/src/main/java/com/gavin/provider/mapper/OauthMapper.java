package com.gavin.provider.mapper;

import com.gavin.provider.dto.Oauth;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OauthMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Oauth record);

    int insertSelective(Oauth record);

    Oauth selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Oauth record);

    int updateByPrimaryKey(Oauth record);

    Oauth selectAllByOpenid(@Param("openid") String openid);

    List<Oauth> selectByGender(@Param("gender") Byte gender);



}