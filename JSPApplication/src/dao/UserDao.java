package dao;


import domain.User;

import java.util.List;


/**
 * @description  用户操作的DAO
 * @author Gavin
 * @date 2019-07-25 10:52

 * @return
 * @throws
 * @since
*/
public interface UserDao {

    public List<User> findAll();
}
