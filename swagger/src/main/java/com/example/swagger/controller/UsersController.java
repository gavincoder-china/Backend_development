package com.example.swagger.controller;

import com.example.swagger.dto.User;
import com.example.swagger.service.UsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@Api(tags = "test", produces = "test")
@RestController
@RequestMapping(value = "/v1")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @ApiOperation("展示一号选手")
    @PostMapping(value = "/show")
    public User select(@Valid User user){

        return usersService.select();
    }
}
