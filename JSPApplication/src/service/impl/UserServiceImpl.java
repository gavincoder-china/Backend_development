package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.User;
import service.UserService;

import java.util.List;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-07-25 10:49
 * @description:
 ************************************************************/
public class UserServiceImpl implements UserService {
   private UserDao dao= new UserDaoImpl();

    @Override
    public List<User> findAll() {
        //调用dao完成查询

        return dao.findAll();
    }
}
