package com.gavin.token.controller;

import com.gavin.token.dto.User;
import com.gavin.token.util.result.ReturnResult;
import com.gavin.token.util.result.ReturnResultUtils;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-09-27 07:59
 * @description:
 ************************************************************/
@Api(tags = "测试", produces = "text/html;charset=UTF-8")
@RestController
@RequestMapping(value = "/v1")
public class UserController {

    @ApiOperation(value = "哈哈哈哈或")
    @GetMapping(value = "/show")
    public User show(@Valid User user) {
        return null;
    }


    @ApiOperation(value = "生成token测试")
    @PostMapping("/login")
    public String login() {

        System.out.println("我进来啦");

        JwtBuilder jwt = Jwts.builder()
                             .setId("6666")
                             .setSubject("gavin")
                             .setIssuedAt(new Date())
                             .signWith(SignatureAlgorithm.HS256, "coder");

        return jwt.compact();

    }

    @ApiOperation(value = " 测试返回结果集")
    @GetMapping(value = "/testReturnResult")
    public ReturnResult<User> testReturnResult() {
        //测试个成功,返回个user类
        User user = new User();
        user.setUsername("gavincoder");
        user.setEmail("xunyegege@gmail.com");

        return ReturnResultUtils.returnSuccess(user);
    }

}
