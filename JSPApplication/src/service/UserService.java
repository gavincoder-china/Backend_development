package service;


import domain.User;

import java.util.List;

/**
 * @author Gavin
 * @description 用户管理的业务接口
 * @date 2019-07-25 09:35
 * @return
 * @throws
 * @since
 */
public interface UserService {
    /**
     * @return java.util.List<domain.User>
     * @throws
     * @description 查询所有用户的信息
     * @author Gavin
     * @date 2019-07-25 10:49
     * @since
     */

    List<User> findAll();

    //返回一个数值
    Integer add(User user);
    //删除
    Integer del(Integer id);
     //findOne  回显查询
    User findOne(Integer id);
    Integer update(User user);

}
