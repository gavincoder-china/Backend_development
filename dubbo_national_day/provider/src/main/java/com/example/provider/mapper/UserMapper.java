package com.example.provider.mapper;

import com.example.provider.dto.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    int deleteByPrimaryKey(Integer id);


    int insert(User record);


    int insertSelective(User record);


    User selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(User record);


    int updateByPrimaryKey(User record);

    User selectByUserName(@Param("userName") String userName);

    int delByUserName(@Param("userName") String userName);

    List<User> selectByAll(User user);

    int countToatlSize(User user);

}