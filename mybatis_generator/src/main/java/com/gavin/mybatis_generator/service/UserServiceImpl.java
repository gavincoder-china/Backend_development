package com.gavin.mybatis_generator.service;

import com.gavin.mybatis_generator.dto.User;
import com.gavin.mybatis_generator.dto.UserExample;
import com.gavin.mybatis_generator.mapper.UserMapper;
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
 * @Date : 2019-09-23 10:45
 * @description:
 ************************************************************/
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User select(){
        String name="gavin";
        UserExample userExample=new UserExample();
        userExample.createCriteria().andUserEqualTo(name);
        List<User> users = userMapper.selectByExample(userExample);

        System.out.println(users);

    }
}
