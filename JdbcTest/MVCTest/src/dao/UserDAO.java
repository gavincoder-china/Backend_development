package dao;

import entity.User;

public interface UserDAO {
//接口,默认是public
int insert(User user);
int delete(User user);
int update(User user);


}
