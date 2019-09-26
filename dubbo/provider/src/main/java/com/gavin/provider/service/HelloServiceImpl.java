package com.gavin.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.gavin.common.model.HelloModel;
import com.gavin.common.service.HelloService;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-09-26 14:24
 * @description:
 ************************************************************/
@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public HelloModel sayHello() {
        HelloModel model = new HelloModel();
        model.setName("hello-dubbo");

        return model;
    }
}
