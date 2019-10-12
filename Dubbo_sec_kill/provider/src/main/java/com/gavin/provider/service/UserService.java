package com.gavin.provider.service;



import com.gavin.provider.dto.Oauth;

import java.util.List;

/**
 * @author gavincoder
 */
public interface UserService {

    String weChatUserLogin(String code);

    List<Oauth> selectByGender(Byte gender);
}
