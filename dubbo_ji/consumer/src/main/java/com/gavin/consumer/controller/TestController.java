package com.gavin.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gavin.provider.model.HelloModel;
import com.gavin.provider.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-09-26 14:28
 * @description:
 ************************************************************/
@RestController
@RequestMapping(value = "/v1")
public class TestController {


    @Reference
    private HelloService helloService;

    @GetMapping(value = "/say")
    public HelloModel say() {
        return helloService.sayHello();

    }

}
