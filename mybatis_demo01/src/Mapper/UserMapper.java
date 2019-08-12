package Mapper;

import Entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {


   List<User>  queryAll();
   int add(@Param("user") User user);
   int del(@Param("id") int id);
   int dd(@Param("id") int id);



List<User> selectByUsernameLike(@Param("likeUsername")String likeUsername);

int updateById(@Param("updated")User updated,@Param("id")Integer id);

 User selectByUsernameAndId(@Param("username")String username,@Param("id")Integer id);



















}
