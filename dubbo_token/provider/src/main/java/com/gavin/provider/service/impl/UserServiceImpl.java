package com.gavin.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.gavin.provider.dto.User;
import com.gavin.provider.mapper.UserMapper;
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
    private UserMapper userMapper;
    @Override
    public List<User> selectall() {
        return userMapper.selectall();
    }
}
