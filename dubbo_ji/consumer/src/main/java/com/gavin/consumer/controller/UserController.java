package com.gavin.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gavin.consumer.config.custom.CurrentUser;
import com.gavin.consumer.config.custom.LoginRequired;
import com.gavin.consumer.contant.ReturnResultContant;
import com.gavin.consumer.contant.UserContant;
import com.gavin.consumer.exception.LoginException;
import com.gavin.consumer.exception.LoginExceptionEnum;
import com.gavin.consumer.util.RedisUtils;
import com.gavin.consumer.util.result.ReturnResult;
import com.gavin.consumer.util.result.ReturnResultUtils;
import com.gavin.consumer.vo.ResultVo;
import com.gavin.consumer.vo.UserVo;
import com.gavin.provider.dto.UserInfo;
import com.gavin.provider.service.UserService;
import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-09-29 09:07
 * @description:
 ************************************************************/
@Slf4j
@Api(tags = "用户")
@RestController
@RequestMapping(value = "/v1")
public class UserController {
    /**
     * @description //导入工具包
     * @author Gavin
     * @date 2019-09-29 10:02
     * @return
     * @throws
     * @since
     */
    @Autowired
    private RedisUtils redisUtils;


    @Reference
    private UserService userService;

    /**
     * @return com.gavin.consumer.util.result.ReturnResult
     * @throws
     * @description 注册
     * @author Gavin
     * @date 2019-09-29 10:02
     * @since
     */
    @ApiOperation("注册")
    @GetMapping(value = "/register")
    public ReturnResult register(@Valid UserVo userVo) {


        //检测是否有这个用户
        Object obj = redisUtils.get(UserContant.REDIS_USER_REGISTER + userVo.getUserName());
        if (obj == null) {

            //转换对象

            UserInfo userInfo = new UserInfo();
            userInfo.setUserName(userVo.getUserName());
            userInfo.setPassword(userVo.getPassword());
            userInfo.setCreateTime(new Date());
            userInfo.setIdDelete(0);
            userInfo.setUserLevel(1);
            userInfo.setUpdateTime(new Date());
            //调用注册接口
            boolean result = userService.userRegister(userInfo);
            redisUtils.set(UserContant.REDIS_USER_REGISTER + userVo.getUserName(), 1);
            //注册成功后插入到redis中

            //返回给前端返回信息

            return ReturnResultUtils.returnSuccess();

        }

        return ReturnResultUtils.returnFail(ReturnResultContant.WRONG, ReturnResultContant.MSG_WRONG_REGISTER);


    }

    /**
     * @return com.gavin.consumer.util.result.ReturnResult
     * @throws
     * @description 登录
     * @author Gavin
     * @date 2019-09-29 10:02
     * @since
     */
    @ApiOperation("登录")
    @GetMapping(value = "/login")
    public ReturnResult login(@Valid UserVo userVo, HttpServletRequest request) {
      //  LoginException loginException = new LoginException(LoginExceptionEnum.LOGIN_FAIL_ECPTION, "自定义异常调试");




        log.info("哈哈哈哈,测试slf4j");

        //获取token
        String token = request.getSession().getId();
        //获取用户信息


        boolean result = userService.userLogin(userVo.getUserName(), userVo.getPassword());
        //调用登录接口
        if (result) {

            //设置过期时间为60秒
            redisUtils.set(token, userVo.getUserName(), UserContant.REDIS_EXPIRE_TIME);
            //返回信息
            return ReturnResultUtils.returnSuccess(token);

        }

        return ReturnResultUtils.returnFail(ReturnResultContant.WRONG, ReturnResultContant.MSG_WRONG_LOGIN);
    }


    @ApiOperation(value = " 通过用户名模糊查询")
    @GetMapping(value = "/userByName")
    public ReturnResult<List<UserInfo>> userByName(@ApiParam(value = "用户名")
                                                   @RequestParam(value = "username") String username) {

        List<UserInfo> userLists = userService.findByUserNameLike(username);

        return ReturnResultUtils.returnSuccess(userLists);

    }


    @ApiOperation(value = " 逻辑删除用户")
    @GetMapping(value = "/delUser")
    public ReturnResult delUser(@ApiParam("用户名")
                                @RequestParam(value = "username") String username) {

        int result = userService.updateIdDeleteByUserName(username);

        return ReturnResultUtils.returnSuccess(result);

    }


    @ApiOperation(value = " 通过时间范围查询用户")
    @GetMapping(value = "/userByTime")
    public ReturnResult<List<UserInfo>> userByTime(@ApiParam(value = "起始时间") @RequestParam(value = "strat") Long start,
                                                   @ApiParam(value = "结束时间") @RequestParam(value = "end") Long end) {

        String start1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(start * 1000));
        String start2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(end * 1000));

        List<UserInfo> lists = userService.selectByUpdateTimeBetween(new Date(start * 1000), new Date(end * 1000));


        //Date parse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date);


        return ReturnResultUtils.returnSuccess(lists);

    }


    /**
     * @return com.gavin.consumer.util.result.ReturnResult
     * @throws
     * @description 你们就看这个方法及其调用的service方法, 其他的方法不要操作
     * @author Gavin
     * @date 2019-09-29 20:58
     * @since
     */
    @ApiOperation("根据条件查用户")
    @GetMapping(value = "/findUser")
    public ReturnResult findUser(@Valid UserVo userVo) {

        UserInfo user = new UserInfo();

        user.setUserName(userVo.getUserName());
        user.setUserLevel(userVo.getLevel());
        user.setpSize(userVo.getPageVo().getpSize());
        user.setsPage(userVo.getPageVo().getsPage());


        // BeanUtils.copyProperties(userVo, user);

        List<UserInfo> allUser = userService.getAllUser(user);

        ResultVo resultVo = new ResultVo();

        ArrayList<UserInfo> resultList = Lists.newArrayList();

        allUser.forEach(userInfo -> {

            resultList.add(userInfo);
        });

        resultVo.setList(resultList);
        resultVo.settSize(userService.getAllUserCount(user));

        return ReturnResultUtils.returnSuccess(resultVo);

    }


    //测试自定义注解
    @ApiOperation("测试自定义注解")
    @LoginRequired
    @GetMapping(value = "/testCustom")
    public String testCustom(@CurrentUser String tokenStr) {

        return tokenStr;
    }

}
