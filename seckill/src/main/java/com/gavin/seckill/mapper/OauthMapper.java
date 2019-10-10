package com.gavin.seckill.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.gavin.seckill.dto.Oauth;

public interface OauthMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Oauth record);

    int insertSelective(Oauth record);

    Oauth selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Oauth record);

    int updateByPrimaryKey(Oauth record);

    Oauth selectAllByOpenid(@Param("openid")String openid);

    List<Oauth> selectByGender(@Param("gender") Byte gender);




}