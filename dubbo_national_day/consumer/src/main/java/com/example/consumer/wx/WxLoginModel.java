package com.example.consumer.wx;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-10-09 10:28
 * @description:
 ************************************************************/
@Component
@ConfigurationProperties(prefix = "wx")
@Data
public class WxLoginModel {
    //请求code的地址

    private String codeUrl;

    private String appId;

    //微信回调地址
    private String redirectUrl;

    //秘钥
    private String secret;

    //请求toekn的地址

    private String tokenUrl;

    private String userInfoUrl;

    //拼接得到真实请求地址
    public String getRealUrl() {
        StringBuffer buffer = new StringBuffer(getCodeUrl());

        //   https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID
        //  &redirect_uri=https://www.test.com&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect
        String realUrl = buffer.append("appid=").append(getAppId())
                               .append("&redirect_uri=")
                               .append(getRedirectUrl())
                               .append("&response_type=code")
                               .append("&scope=snsapi_userinfo")
                               .append("&state=STATE")
                               .append("#wechat_redirect")
                               .toString();
        return realUrl;
    }
    //https://api.weixin.qq.com/sns/oauth2/access_token?appid=
    // APPID&secret=SECRET&code=CODE&grant_type=authorization_code

    public String getAccessTokenUrl(String code) {
        StringBuffer buffer = new StringBuffer(getTokenUrl());
        String tokenUrl = buffer.append(getAppId())
                                .append("&secret=")
                                .append(getSecret())
                                .append("&code=")
                                .append(code)
                                .append("&grant_type=authorization_code")
                                .toString();
        return tokenUrl;
    }

    public String getUserInfoUrl(String accessToken, String openid) {
        StringBuffer buffer = new StringBuffer(getUserInfoUrl());
        String UserInfoUrl = buffer.append(accessToken)
                                   .append("&openid=")
                                   .append(openid)
                                   .append("&lang=zh_CN")
                                   .toString();

        return UserInfoUrl;
    }


}
