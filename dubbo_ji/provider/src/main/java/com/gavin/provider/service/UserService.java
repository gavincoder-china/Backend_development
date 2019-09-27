package com.gavin.provider.service;

import com.gavin.provider.dto.Users;

import java.util.List;

public interface UserService {
    List<Users> selectall();

    int insertSelective();
    Users find(String name,String password);
}
