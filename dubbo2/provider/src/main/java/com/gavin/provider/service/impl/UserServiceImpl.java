package com.gavin.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.gavin.api.service.UserService;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-09-25 16:59
 * @description:
 ************************************************************/
@Service(version = "1.0.0")
public class UserServiceImpl implements UserService {

    @Override
    public String sayHello() {
        return "hello dubbo";
    }
}
