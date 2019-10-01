package com.example.swagger.controller;

import com.example.swagger.dto.User;
import com.example.swagger.service.UsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
@Api(tags = "tags", produces = "text/html;charset=UTF-8")
@RestController
@RequestMapping(value = "/v1")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @ApiOperation("展示一号选手valid")
    @PostMapping(value = "/show")
    public User select(@Valid User user) {

        return usersService.select();
    }

    @ApiOperation("展示二号选手requestbody")
    @PostMapping(value = "/show2")
    public User select2(@RequestBody User user) {

        return usersService.select();
    }

    @ApiOperation("展示三号选手apiparam")
    @PostMapping(value = "/show3")
    public User select3(@ApiParam(value = "name", required = true) String name) {

        return usersService.select();
    }


}
