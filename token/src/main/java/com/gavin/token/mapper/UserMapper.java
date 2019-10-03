package com.gavin.token.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.gavin.token.dto.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    User selectAllByUsername(@Param("username")String username);



}