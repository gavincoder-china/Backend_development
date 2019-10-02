package com.example.provider.service;

import com.example.provider.dto.User;

import java.util.List;

public interface UserService {

    User login(String userName,String password);
    int register(User user);
    int delUser(String userName);
    List<User> findUser(User user);
    int countToatlSize(User user);
}
