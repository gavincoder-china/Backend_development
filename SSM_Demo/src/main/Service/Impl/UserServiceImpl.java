package main.Service.Impl;

import main.Entity.Users;
import main.Mapper.UsersMapper;
import main.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-08-20 16:17
 * @description:
 ************************************************************/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UsersMapper mapper;
    @Override
    public Users login(String name, String password) {


        Users users = mapper.selectbynameAndPassword(name, password);

        return users;
    }

    @Override
    public Integer register(Users user) {
        int insert = mapper.insert(user);
        return insert;
    }

    @Override
    public List<Users> selectAll() {
        List<Users> list = mapper.selectall();

        return list;
    }

}
