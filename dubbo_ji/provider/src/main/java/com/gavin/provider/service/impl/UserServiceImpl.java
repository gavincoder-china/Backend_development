package com.gavin.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.gavin.provider.dto.Users;
import com.gavin.provider.mapper.UsersMapper;
import com.gavin.provider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-09-27 12:03
 * @description:
 ************************************************************/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UsersMapper userMapper;

    @Override
    public List<Users> selectall() {

        return userMapper.selectAll();
    }

    @Override
    public int insertSelective() {
        Users user = new Users();
        user.setId(88888);
        user.setName("9999999");
        user.setPassword("99999999");
        return userMapper.insertSelective(user);

    }


    //登录验证
    @Override
    public Users find(String name, String password) {
        //从mybatis中获取用户信息(数据库表字段设置为not null)
        Users user = userMapper.findAllByName(name);

        //匹配验证
        if (null !=user){
            if (password.equals(user.getPassword())){

                return user;
            }

        }

        return null;
    }
}
