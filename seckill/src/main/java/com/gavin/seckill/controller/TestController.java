package com.gavin.seckill.controller;

import com.gavin.seckill.annotation.AnnotationCurrentUser;
import com.gavin.seckill.annotation.AnnotationLoginRequired;
import com.gavin.seckill.dto.Oauth;
import com.gavin.seckill.result.ReturnResult;
import com.gavin.seckill.result.ReturnResultContants;
import com.gavin.seckill.result.ReturnResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-10-10 11:41
 * @description:
 ************************************************************/
@Api(tags = "测试")
@RestController
@RequestMapping(value = "/v1")
public class TestController {

    @ApiOperation(value = "测试自定义拦截注解")
    @AnnotationLoginRequired
    @GetMapping("/test")
    public ReturnResult testAnnoation(@AnnotationCurrentUser Oauth oauth) {

        if (null != oauth) {

            return ReturnResultUtils.returnSuccess(oauth);
        }

        return ReturnResultUtils.returnFail(ReturnResultContants.LOGIN_WRONG,
                                            ReturnResultContants.MSG_INTERCPTOR_LOGIN_ERROR);

    }

    @ApiOperation(value = "平平生日快乐")
    @GetMapping(value = "/happy")
    public String happyBirthDay() {

        //彩蛋❤️
        return "2019-10-10,🐖我亲爱的平平生日快乐❤️";
    }


}
