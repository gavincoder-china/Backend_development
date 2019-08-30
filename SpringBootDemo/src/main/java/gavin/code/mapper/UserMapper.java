package gavin.code.mapper;

import com.alibaba.druid.sql.dialect.oracle.ast.stmt.OracleSelectJoin;
import gavin.code.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

   List<User> selectuser(Integer id);

}