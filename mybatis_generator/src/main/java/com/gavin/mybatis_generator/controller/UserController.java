package com.gavin.mybatis_generator.controller;

import com.gavin.mybatis_generator.service.UserService;
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
 * @Date : 2019-09-23 10:46
 * @description:
 ************************************************************/
@RestController
@RequestMapping(value = "/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/show")
    public void select() {
         userService.select();
    }

}
