package service;


import domain.User;

import java.util.List;

/**
 * @description  用户管理的业务接口
 * @author Gavin
 * @date 2019-07-25 09:35

 * @return
 * @throws
 * @since
*/
public interface UserService {
/**
 * @description   查询所有用户的信息
 * @author Gavin
 * @date 2019-07-25 10:49

 * @return java.util.List<domain.User>
 * @throws
 * @since
*/

public List<User> findAll();




}
