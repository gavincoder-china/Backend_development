package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.User;
import service.UserService;

import java.util.List;

/**
 * **********************************************************
 *
 * @Project: 完成查询
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-07-25 10:49
 * @description:
 ************************************************************/
public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
        //调用dao完成查询

        return dao.findAll();
    }

    @Override
    public Integer add(User user) {
        UserDao dao = new UserDaoImpl();
        Integer add = dao.add(user);
        return add;
    }

    @Override
    public Integer del(Integer id) {
        UserDao dao = new UserDaoImpl();
        Integer del = dao.del(id);
        return del;
    }

    @Override
    public User findOne(Integer id) {
        UserDao dao = new UserDaoImpl();
        User user = dao.findOne(id);
        return user;
    }

    @Override
    public Integer update(User user) {
        UserDao dao = new UserDaoImpl();
        Integer updateResult = dao.update(user);
        return updateResult;
    }
}
