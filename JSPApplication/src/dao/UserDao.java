package dao;


import domain.User;

import java.util.List;
import java.util.Map;


/**
 * @author Gavin
 * @description 用户操作的DAO
 * @date 2019-07-25 10:52
 * @return
 * @throws
 * @since
 */
public interface UserDao {

    List<User> findAll();

    Integer add(User user);

    Integer del(Integer id);

    User findOne(Integer id);

    Integer update(User user);

    //查询总记录数
    int findTotalCount(Map<String, String[]> condition);

    //分页查询
    List<User> findByPage(int start, int rows, Map<String, String[]> condition);

}
