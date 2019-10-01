package com.gavin.provider.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class User implements Serializable {
    /**
    * id
    */
    private Integer id;

    /**
    * uername
    */
    private String username;

    /**
    * password
    */
    private String password;

    /**
    * phone
    */
    private String phone;

    /**
    * email
    */
    private String email;

    /**
    * create_time 注册时间
    */
    private Date registerTime;

    /**
    * update_time 最后登录时间
    */
    private Date updateTime;

    /**
    * login_times 登陆次数
    */
    private String loginTimes;

    /**
    * question 找回密码密保问题
    */
    private String question;

    /**
    * answer 找回密码密保答案
    */
    private String answer;

    /**
    * image 头像图片的地址
    */
    private String image;

    @Override
    public String toString() {
        return "User{" +
               "id=" + id +
               ", username='" + username + '\'' +
               ", password='" + password + '\'' +
               ", phone='" + phone + '\'' +
               ", email='" + email + '\'' +
               ", registerTime=" + registerTime +
               ", updateTime=" + updateTime +
               ", loginTimes='" + loginTimes + '\'' +
               ", question='" + question + '\'' +
               ", answer='" + answer + '\'' +
               ", image='" + image + '\'' +
               '}';
    }
}