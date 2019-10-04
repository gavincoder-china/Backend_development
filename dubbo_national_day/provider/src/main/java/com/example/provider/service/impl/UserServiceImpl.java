package com.example.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.provider.dto.User;
import com.example.provider.mapper.UserMapper;
import com.example.provider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-10-02 16:23
 * @description:
 ************************************************************/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public User login(String userName, String password) {

        User user = userMapper.selectByUserName(userName);
        if (null !=user && encoder.matches(password,user.getPassword())){
            return user;
        }
        return null;

    }

    @Override
    public int register(User user) {

       user.setPassword(encoder.encode(user.getPassword()));

        return userMapper.insertSelective(user);
    }

    @Override
    public int delUser(String userName) {

        return userMapper.delByUserName(userName);
    }

    @Override
    public List<User> findUser(User user) {

        return userMapper.selectByAll(user);
    }

    @Override
    public int countToatlSize(User user) {
        return userMapper.countToatlSize(user);
    }
}
