package com.gavin.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gavin.consumer.util.RedisUtils;
import com.gavin.provider.dto.Users;
import com.gavin.provider.service.HelloService;
import com.gavin.provider.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
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
@RequestMapping(value = "/v2")
@Api(tags = "测试")
public class UserController {
    @Reference
    private UserService userService;

    @Reference
    private HelloService helloService;


    @Autowired
    private RedisUtils redisUtils;

    @ApiOperation(value = "查询全部")
    @GetMapping(value = "/show")
    public String show() {
        List<Users> selectall = userService.selectall();
        System.out.println(selectall);
        String s = JSON.toJSONString(selectall);
        return s;
    }

    @ApiOperation(value = "插入测试")
    @GetMapping(value = "/show2")
    public int show2() {

        return userService.insertSelective();
    }


    @ApiOperation(value = "redis测试")
    @GetMapping(value = "/show3")
    public String show3() {

        redisUtils.set("name", "gavin");

        return (String) redisUtils.get("name");
    }

    @ApiOperation(value = "登录")
    @GetMapping(value = "/login")
    public String login(@ApiParam(value = "账户名", required = true) @RequestParam(value = "name") String name,
                        @ApiParam(value = "密码", required = true) @RequestParam(value = "password") String password,
                        HttpServletRequest request) {

        //设置redis最终set的状态
        boolean result = false;

        //获取session
        String token = request.getSession().getId();

        //调用service层验证方法
        Users users = userService.find(name, password);

        //对service层返回的数据进行空值检验
        if (null != users) {

            //如果不是空值,则将该数据用fastjson转换成字符串
            String jsonString = JSONObject.toJSONString(users);

            //将token作为key,jsonString作为value存入redis//并返回boolean类型
            result = redisUtils.set(token, jsonString);

        }

        //如果存redis返回的是true,则将token传给前端,以表明登陆成功
        if (result) {
            return token;
        }
        //登录失败,返回空
        return null;
    }

    @ApiOperation(value = "校验")
    @GetMapping(value = "/check")
    public String check(@ApiParam(value = "token", required = true) @RequestParam(value = "token") String token) {

        //通过前端传来的token作为key去redis中拿取数据
        String value = (String) redisUtils.get(token);

        //如果有数据,则返回该数据
        if (null != value) {
            return value;
        }
        //没数据,则返回空
        return null;
    }

    @ApiOperation(value = " 退出登录")
    @GetMapping(value = "/exit")
    public boolean exit(@ApiParam(value = "退出登录", required = true) @RequestParam(value = "token") String token) {

        //从redis中删除该token
        redisUtils.del(token);

        return true;

    }



}
