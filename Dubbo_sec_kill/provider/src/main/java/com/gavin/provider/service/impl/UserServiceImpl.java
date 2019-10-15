package com.gavin.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONObject;

import com.gavin.provider.contants.RedisUserContants;
import com.gavin.provider.dto.Oauth;
import com.gavin.provider.mapper.OauthMapper;
import com.gavin.provider.service.UserService;
import com.gavin.provider.util.IdWorker;
import com.gavin.provider.util.RedisUtils;
import com.gavin.provider.util.UrlUtils;
import com.gavin.provider.wxUtil.WxLoginModel;
import org.springframework.beans.factory.annotation.Autowired;


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
 * @Date : 2019-10-10 12:00
 * @description:
 ************************************************************/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private WxLoginModel wxLoginModel;
    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private OauthMapper oauthMapper;

    @Override
    public String weChatUserLogin(String code) {

        String accessTokenUrl = wxLoginModel.getAccessTokenUrl(code);

        String accessTokenUrlJson = UrlUtils.loadURL(accessTokenUrl);

        JSONObject accessTokenJsonObject = JSONObject.parseObject(accessTokenUrlJson);

        String openid = accessTokenJsonObject.getString("openid");
        String accessToken = accessTokenJsonObject.getString("access_token");

        //判断是否已经注册
        Object obj = redisUtils.get(RedisUserContants.REGISTER_NAME_SPACE + openid);

        if (null == obj) {
            //判断没有注册,先注册一下


            String userInfoUrl = wxLoginModel.getUserInfoUrl(accessToken, openid);

            String userInfoJson = UrlUtils.loadURL(userInfoUrl);
            JSONObject userInfoJsonObject = JSONObject.parseObject(userInfoJson);

            Oauth oauth = new Oauth();


            oauth.setId(idWorker.nextId());
            oauth.setOpenid(userInfoJsonObject.getString("openid"));
            oauth.setGender(userInfoJsonObject.getByte("sex"));
            oauth.setNickname(userInfoJsonObject.getString("nickname"));
            oauth.setHeadImgUrl(userInfoJsonObject.getString("headimgurl"));
            oauth.setCountry(userInfoJsonObject.getString("country"));
            oauth.setProvince(userInfoJsonObject.getString("province"));
            oauth.setCity(userInfoJsonObject.getString("city"));
            oauth.setCreateTime(new Date());
            oauth.setOauthName("wx");
            int result = oauthMapper.insertSelective(oauth);

            if (result != 1) {
                //创建失败
                return null;
            } else {

                //创建成功,将数据存redis中
                redisUtils.set(RedisUserContants.REGISTER_NAME_SPACE + openid, 1);
            }
        }

        //已经注册的话,去数据库查数据,返回oauth
        Oauth oauth = oauthMapper.selectAllByOpenid(openid);
        String oauthJsonStr = JSONObject.toJSONString(oauth);

        //存入登录redis,并设置过期时间10分钟
        redisUtils.set(RedisUserContants.LOGIN_NAME_SPACE + accessToken,
                       oauthJsonStr,
                       1000);

        return accessToken;

    }

    @Override
    public List<Oauth> selectByGender(Byte gender) {
        return oauthMapper.selectByGender(gender);

    }
}
