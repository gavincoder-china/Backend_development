package com.gavin.provider.controller;

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
 * @Date : 2019-10-05 15:40
 * @description:
 ************************************************************/
@RestController
@RequestMapping("/pro")
public class TestController {

    @GetMapping(value = "/hello")
    public String hello() {
        return "hello spring cloud";
    }
}
