package com.example.swagger.controller;

import com.example.swagger.dto.User;
import com.example.swagger.service.UsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-09-23 15:57
 * @description:
 ************************************************************/
@Api(tags = "tags2", produces = "text/html;charset=UTF-8")
@RestController
@RequestMapping(value = "/v2")
public class UsersController2 {

    @Autowired
    private UsersService usersService;

    @ApiOperation("展示一号选手")
    @PostMapping(value = "/show")
    public User select(@Valid User user){

        return usersService.select();
    }
}
