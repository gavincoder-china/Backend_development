package com.gavin.consumer.controller;



import com.alibaba.dubbo.config.annotation.Reference;
import com.gavin.consumer.config.annotationCustom.AnnotationLoginRequired;
import com.gavin.consumer.result.ReturnResult;
import com.gavin.consumer.contants.ReturnResultContants;
import com.gavin.consumer.result.ReturnResultUtils;
import com.gavin.provider.dto.Oauth;
import com.gavin.provider.service.UserService;
import com.gavin.provider.wxUtil.WxLoginModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

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


    private WxLoginModel wxLoginModel;

    @Reference
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


    /**
     * @description   判断用户是否登录
     * @author Gavin
     * @date 2019-10-14 08:49

     * @return
     * @throws
     * @since
    */




}
