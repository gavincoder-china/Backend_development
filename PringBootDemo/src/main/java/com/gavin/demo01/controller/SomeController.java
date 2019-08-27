package com.gavin.demo01.controller;

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
 * @Date : 2019-08-27 20:03
 * @description:
 ************************************************************/
@RestController
@RequestMapping("v1")
public class SomeController {
    @GetMapping("/some")
public String someHandler(){
    return "hello   springboot";
}
}
