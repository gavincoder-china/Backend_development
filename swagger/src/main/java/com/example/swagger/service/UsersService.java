package com.example.swagger.service;

import com.example.swagger.dto.User;
import com.example.swagger.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-09-23 15:56
 * @description:
 ************************************************************/
@Service
public class UsersService {
    @Autowired
    private UserMapper userMapper;

    public User select(){

        return  userMapper.selectByPrimaryKey(1);

    }


}
