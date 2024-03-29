package com.gavin.seckill.controller;


import com.gavin.seckill.annotation.AnnotationLoginRequired;
import com.gavin.seckill.dto.Oauth;
import com.gavin.seckill.result.ReturnResult;
import com.gavin.seckill.result.ReturnResultContants;
import com.gavin.seckill.result.ReturnResultUtils;
import com.gavin.seckill.service.UserService;
import com.gavin.seckill.wx.WxLoginModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-10-09 10:27
 * @description:
 ************************************************************/

@Controller
@RequestMapping(value = "/wx")
public class WxController {
    @Autowired
    private WxLoginModel wxLoginModel;

    @Autowired
    private UserService userService;

    private String wxToken;

    @GetMapping(value = "/getCode")
    public String getCode() {

        //将生成的链接返回到前端并重定向到链接地址
        // 为了使用redirect重定向方法,不可加上@restcontroller  @ResponseBody
        //这边你也可以使用二维码生成器生成二维码图像进行扫码
        return "redirect:" + wxLoginModel.getRealUrl();
    }


    @GetMapping(value = "/callBack")
    @ResponseBody
    public ReturnResult callBack(String code) {

        String wxToken = userService.weChatUserLogin(code);


        if (null == wxToken) {
            return ReturnResultUtils.returnFail(ReturnResultContants.LOGIN_WRONG, ReturnResultContants.MSG_WRONG_LOGIN);
        }

        this.wxToken=wxToken;

        HashMap<String, String> map = new HashMap<>();
        map.put("wxToken",wxToken);

        return ReturnResultUtils.returnSuccess(map);

    }


    @AnnotationLoginRequired
    @ApiOperation(value = "/通过性别查用户")
    @GetMapping(value = "/getByGender")
    @ResponseBody
    public ReturnResult getByGender(@ApiParam(value = "性别",required = true) @RequestParam(value = "gender") Byte gender) {

        List<Oauth> oauths = userService.selectByGender(gender);

        return ReturnResultUtils.returnSuccess(oauths);

    }

    @ApiOperation(value = "/获取微信token")
    @GetMapping(value = "/getWxToken")
    @ResponseBody
    public ReturnResult getWxToken(){
        return ReturnResultUtils.returnSuccess(this.wxToken);
    }

}
