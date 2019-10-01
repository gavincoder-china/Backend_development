package com.gavin.provider.mapper;

import com.alibaba.druid.sql.ast.SQLLimit;
import com.gavin.provider.dto.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface UserInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    UserInfo findByUserName(@Param("userName") String userName);

    List<UserInfo> findAll(@Param("start") int start, @Param("end") int end);

    List<UserInfo> findByUserNameLike(@Param("likeUserName")String likeUserName);

    int updateIdDeleteByUserName(@Param("userName")String userName);

    List<UserInfo> selectByUpdateTimeBetween(@Param("minUpdateTime")Date minUpdateTime,@Param("maxUpdateTime")Date maxUpdateTime);

    List<UserInfo> find();

    List<UserInfo> getAllUser(UserInfo userInfo);

    int getAllUserCount(UserInfo userInfo);












}