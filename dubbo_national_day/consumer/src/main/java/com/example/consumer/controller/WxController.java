package com.example.consumer.controller;


import com.alibaba.fastjson.JSONObject;

import com.example.consumer.util.QRCodeUtil;
import com.example.consumer.util.UrlUtils;
import com.example.consumer.wx.WxLoginModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

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


    @GetMapping(value = "/getCode")
    public String getCode() throws IOException {

        ByteArrayOutputStream qrGen = QRCodeUtil.createQrGen(wxLoginModel.getRealUrl());

        return "redirect:"+wxLoginModel.getRealUrl();
//        return QRCodeUtil.createQrGen(wxLoginModel.getRealUrl());
    }


    @GetMapping(value = "/callBack")
    public String callBack(String code){


        String accessTokenUrl = wxLoginModel.getAccessTokenUrl(code);


        String accessTokenUrlJson = UrlUtils.loadURL(accessTokenUrl);

        JSONObject accessTokenJsonObject = JSONObject.parseObject(accessTokenUrlJson);

        String accessToken = accessTokenJsonObject.getString("access_token");
        String openid = accessTokenJsonObject.getString("openid");

        String userInfoUrl = wxLoginModel.getUserInfoUrl(accessToken, openid);

        String userInfoJson = UrlUtils.loadURL(userInfoUrl);

        JSONObject userInfoJsonObject = JSONObject.parseObject(userInfoJson);

        return "redirect:";

    }

    @GetMapping(value = "/happy")
    @ResponseBody
    public String happyBirthDay(){


        //https://api.weixin.qq.com/sns/oauth2/access_token?appid=
        // APPID&secret=SECRET&code=CODE&grant_type=authorization_code
        return "🐖我亲爱的平平生日快乐";
    }


}
