package com.gavin.token.controller;

import com.gavin.token.dto.User;
import com.gavin.token.mapper.UserMapper;
import com.gavin.token.util.result.ReturnResult;
import com.gavin.token.util.result.ReturnResultContants;
import com.gavin.token.util.result.ReturnResultUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BCryptPasswordEncoder encoder;

    private String secret_salt = "coder";

    @ApiOperation(value = "登录")
    @PostMapping(value = "/login")
    public ReturnResult login(@ApiParam(value = "用户名") @RequestParam(value = "userName") String userName,
                              @ApiParam(value = "密码") @RequestParam(value = "password") String password) {

        User user = userMapper.selectAllByUsername(userName);

        if (null != user && encoder.matches(password, user.getPassword())) {

            //为了方便测试，我们将过期时间设置为1分钟
            //当前时间
            long now = System.currentTimeMillis();
            //过期时间为1分钟
            long exp = now + 1000 * 60;
            String token = Jwts.builder()
                               .setId("666")
                               .setSubject(userName)
                               .setIssuedAt(new Date())
                               .signWith(SignatureAlgorithm.HS256, secret_salt)
                               .setExpiration(new Date(exp))
                               .compact();


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
     * @description 验证登录
     * @author Gavin
     * @date 2019-10-03 17:38
     * @since
     */
    @ApiOperation(value = " 验证是否登录")
    @PostMapping(value = "/check")
    public ReturnResult checkLogin(@ApiParam(value = "token") @RequestParam(value = "token") String token) {
        Claims claims = Jwts.parser().setSigningKey(secret_salt).parseClaimsJws(token).getBody();
        String id = claims.getId();
        String subject = claims.getSubject();
        Date issuedAt = claims.getIssuedAt();




        ArrayList<String> list = new ArrayList<>();
        list.add(id);
        list.add(subject);

        return ReturnResultUtils.returnSuccess(list);


    }


}
