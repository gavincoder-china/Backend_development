package dao;


import domain.User;

import java.util.List;


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
}
