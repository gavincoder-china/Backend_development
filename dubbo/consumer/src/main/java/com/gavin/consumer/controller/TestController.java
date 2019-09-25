package com.gavin.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gavin.provider.service.ProviderService;
import com.gavin.webapi.service.ApiTest;
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
 * @Date : 2019-09-25 11:06
 * @description:
 ************************************************************/
@RestController
@RequestMapping(value = "/v1")
public class TestController {

//    @Reference(version = "1.0.0", url = "dubbo://127.0.0.1:12345")
//    private ApiTest apiTest;
//
//    @GetMapping("/say")
//    public String sayHello(){
//
//        return apiTest.sayHello();
//    }

    @Reference
    private ProviderService providerService;

    @GetMapping(value = "/show")
    public String sayHello() {
        return providerService.sayHello();
    }

}
