package com.gavin.token.controller;

import com.gavin.token.config.myAnnotation.AnnotationCurrentUser;
import com.gavin.token.config.myAnnotation.AnnotationLoginRequired;
import com.gavin.token.dto.User;
import com.gavin.token.mapper.UserMapper;
import com.gavin.token.util.IdWorker;
import com.gavin.token.util.JwtUtil;
import com.gavin.token.util.result.ReturnResult;
import com.gavin.token.util.result.ReturnResultContants;
import com.gavin.token.util.result.ReturnResultUtils;
import io.jsonwebtoken.Claims;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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
@Slf4j
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private IdWorker idWorker;

    @ApiOperation(value = "登录")
    @PostMapping(value = "/login")
    public ReturnResult login(@ApiParam(value = "用户名") @RequestParam(value = "userName") String userName,
                              @ApiParam(value = "密码") @RequestParam(value = "password") String password) {

        User user = userMapper.selectAllByUsername(userName);

        if (null != user && encoder.matches(password, user.getPassword())) {


            String token = jwtUtil.createJwt(user.getId(), user.getUsername());


            return ReturnResultUtils.returnSuccess(token);

        }

        return ReturnResultUtils.returnFail(ReturnResultContants.LOGIN_WRONG, ReturnResultContants.MSG_WRONG_LOGIN);
    }

    /**
     * @return
     * @throws
     * @description 简单注册测试
     * @author Gavin
     * @date 2019-10-03 16:46
     * @since
     */
    @ApiOperation(value = " 注册")
    @PostMapping(value = "/register")
    public ReturnResult register(@ApiParam(value = "用户名") @RequestParam(value = "userName") String userName,
                                 @ApiParam(value = "密码") @RequestParam(value = "password") String password) {

        String encode = encoder.encode(password);



        User user = new User();
        user.setUsername(userName);
        user.setPassword(encode);
        user.setId(idWorker.nextId());
       // System.out.println(idWorker.nextId());

        int result = userMapper.insertSelective(user);

        if (result == 1) {
            return ReturnResultUtils.returnSuccess();
        }
        return ReturnResultUtils.returnFail(ReturnResultContants.REGISTER_WRONG,
                                            ReturnResultContants.MSG_WRONG_REGISTER);

    }

    /**
     * @return
     * @throws
     * @description 验证登录,解析token
     * @author Gavin
     * @date 2019-10-03 17:38
     * @since
     */
    @ApiOperation(value = " 解析token,验证是否登录")
    @PostMapping(value = "/check")
    public ReturnResult checkLogin(@ApiParam(value = "token") @RequestParam(value = "token") String token) {

        try {
            Claims claims = jwtUtil.parseJWT(token);


            String id = claims.getId();
            String userName = claims.getSubject();


            return ReturnResultUtils.returnSuccess(id+userName);
        }
        catch (Exception e) {
            log.error(ReturnResultContants.MSG_LOGIN_EXPIRE);
        }

        return ReturnResultUtils.returnFail(ReturnResultContants.LOGIN_EXPIRE, ReturnResultContants.MSG_LOGIN_EXPIRE);
    }


    /**
     * @description   查询用户信息,测试自定义注解拦截器
     * @author Gavin
     * @date 2019-10-04 12:03

     * @return
     * @throws
     * @since
    */
    @AnnotationLoginRequired
    @ApiOperation(value = "查询用户信息 ")
    @GetMapping(value = "/findUserInfo")
    public ReturnResult findUserInfo(@AnnotationCurrentUser String userName){

        return ReturnResultUtils.returnSuccess(userName);


    }

}
