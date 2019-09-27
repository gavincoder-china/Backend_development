package com.gavin.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.gavin.provider.model.HelloModel;
import com.gavin.provider.service.HelloService;


@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public HelloModel sayHello() {
        HelloModel model = new HelloModel();
        model.setName("hello-dubbo");

        return model;
    }

}
