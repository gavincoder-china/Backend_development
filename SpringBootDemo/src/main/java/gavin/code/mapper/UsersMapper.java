package gavin.code.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import gavin.code.entity.Users;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UsersMapper {

    List<Users> selectAll();


}