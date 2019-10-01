package com.gavin.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.gavin.provider.dto.User;
import com.gavin.provider.model.HelloModel;
import com.gavin.provider.service.HelloService;
import com.gavin.provider.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-09-27 12:04
 * @description:
 ************************************************************/
@RestController
@RequestMapping(value = "/v1")
@Api(tags = "测试")
public class UserController {
    @Reference
    private UserService userService;

    @Reference
    private HelloService helloService;

    @ApiOperation(value = "查询")
    @GetMapping(value = "/show")
    public String show(){
        List<User> selectall = userService.selectall();
        System.out.println(selectall);
        String s = JSON.toJSONString(selectall);
        return s;
    }

    @ApiOperation(value = "hello")
    @GetMapping(value = "/show2")
    public HelloModel show2(){
        return helloService.sayHello();
    }
}
