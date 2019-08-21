package main.Mapper;
import java.util.List;

import main.Entity.Users;import org.apache.ibatis.annotations.Param;

public interface UsersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    Users selectbynameAndPassword(@Param("name") String name, @Param("password") String password);

    List<Users> selectall();



}