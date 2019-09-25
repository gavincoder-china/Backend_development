package com.gavin.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.gavin.webapi.service.ApiTest;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-09-25 11:05
 * @description:
 ************************************************************/
@Service(version = "1.0.0")
public class ApiTestImpl implements ApiTest {
    @Override
    public String sayHello() {
        return "hello-dubbo";
    }
}
