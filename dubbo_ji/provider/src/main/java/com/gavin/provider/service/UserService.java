package com.gavin.provider.service;

import com.gavin.provider.dto.UserInfo;

import java.util.Date;
import java.util.List;

public interface UserService {
    boolean userLogin(String username, String password);

    boolean userRegister(UserInfo userInfo);

    List<UserInfo> findAll(int start, int end);


    /**
     * @return java.util.List<com.gavin.provider.dto.UserInfo>
     * @throws
     * @description 获取某个等级的全部用户信息
     * @author Gavin
     * @date 2019-09-29 10:01
     * @since
     */
    List<UserInfo> findUserByLevel(int level);

    /**
     * @return java.util.List<com.gavin.provider.dto.UserInfo>
     * @throws
     * @description 能够根据userName字段模糊查询用户
     * @author Gavin
     * @date 2019-09-29 11:25
     * @since
     */

    List<UserInfo> findByUserNameLike(String UserName);

    int updateIdDeleteByUserName(String userName);

    List<UserInfo> selectByUpdateTimeBetween(Date minUpdateTime, Date maxUpdateTime);


    /**
     * @return java.util.List<com.gavin.provider.dto.UserInfo>
     * @throws
     * @description 最终方法
     * @author Gavin
     * @date 2019-09-29 14:31
     * @since
     */
    List<UserInfo> getAllUser(UserInfo userInfo);

    int getAllUserCount(UserInfo userInfo);


}
