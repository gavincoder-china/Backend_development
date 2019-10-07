package com.gavin.consumer.controller;

import com.gavin.consumer.client.ProClient;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @Date : 2019-10-05 15:46
 * @description:
 ************************************************************/

@RestController
@RequestMapping(value = "/con")
public class HelloController {

    @Autowired
    private ProClient proClient;


    @GetMapping(value = "/hello")
    public String hello(){
        return proClient.hello();
        //return proClient.hello();
    }


}
