package com.gavin.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.gavin.common.model.HelloModel;
import com.gavin.common.service.HelloService;


@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public HelloModel sayHello() {
        HelloModel model = new HelloModel();
        model.setName("hello-dubbo-1副本");

        return model;
    }
}
