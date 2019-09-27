package com.gavin.provider.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.gavin.provider.dto.Users;

public interface UsersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);
    List<Users> selectAll();

    Users findAllByName(@Param("name")String name);



}