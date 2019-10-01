package com.gavin.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.gavin.provider.dto.UserInfo;
import com.gavin.provider.mapper.UserInfoMapper;
import com.gavin.provider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-09-29 09:19
 * @description:
 ************************************************************/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public boolean userLogin(String username, String password) {
        //调用查询方法
        UserInfo user = userInfoMapper.findByUserName(username);

        if (password.equals(user.getPassword())) {
            //密码相同,登陆成功
            return true;

        }
        return false;
    }

    @Override
    public boolean userRegister(UserInfo userInfo) {
        //拿到数据后插入到数据库中

        int result = 0;
        try {
            result = userInfoMapper.insertSelective(userInfo);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        if (result == 1) {
            return true;
        }
        return false;
    }

    @Override
    public List<UserInfo> findAll(int start, int end) {

        return userInfoMapper.findAll(start, end);

    }

    @Override
    public List<UserInfo> findUserByLevel(int level) {

        //先拿到这个用户列表
        List<UserInfo> userLists = userInfoMapper.find();

        List<UserInfo> collect = userLists.stream().filter(userInfo -> userInfo.getUserLevel() == level).collect(Collectors.toList());


        return collect;
    }

    //模糊查询用户
    @Override
    public List<UserInfo> findByUserNameLike(String UserName) {

        return userInfoMapper.findByUserNameLike(UserName);

    }

    //删除用户
    @Override
    public int updateIdDeleteByUserName(String userName) {

        return userInfoMapper.updateIdDeleteByUserName(userName);
    }

    //筛选时间段内的用户
    @Override
    public List<UserInfo> selectByUpdateTimeBetween(Date minUpdateTime, Date maxUpdateTime) {

        System.out.println(minUpdateTime);
        System.out.println(maxUpdateTime);
        List<UserInfo> userInfos = userInfoMapper.selectByUpdateTimeBetween(minUpdateTime, maxUpdateTime);

        System.out.println(userInfos);


        return userInfos;

    }


    @Override
    public List<UserInfo> getAllUser(UserInfo userInfo) {

        return userInfoMapper.getAllUser(userInfo);
    }

    @Override
    public int getAllUserCount(UserInfo userInfo) {
        return userInfoMapper.getAllUserCount(userInfo);
    }


}
