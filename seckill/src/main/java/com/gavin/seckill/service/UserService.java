package com.gavin.seckill.service;

import com.gavin.seckill.dto.Oauth;

import java.util.List;

/**
 * @author gavincoder
 */
public interface UserService {

    String weChatUserLogin(String code);

    List<Oauth> selectByGender(Byte gender);
}
