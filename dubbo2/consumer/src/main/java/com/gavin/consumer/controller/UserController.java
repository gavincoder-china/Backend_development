package com.gavin.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gavin.api.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-09-25 17:32
 * @description:
 ************************************************************/
@RestController
public class UserController {

    @Reference(version = "1.0.0")
    private UserService userService;


    @GetMapping(value = "/say")
    public String sayHello(){

        return userService.sayHello();
    }

    @GetMapping(value = "/say2")
    public String sayHello2(){

        return "hello";
    }
}
