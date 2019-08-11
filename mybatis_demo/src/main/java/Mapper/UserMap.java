package Mapper;

import Entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMap {
    User get(@Param("id") int id);
}
