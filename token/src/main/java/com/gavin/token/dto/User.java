package com.gavin.token.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@ApiModel
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 4407436932114163278L;
    /**
     * id
     */
    private Integer id;

    /**
     * uername
     */
    @ApiModelProperty(value = "哈哈哈哈")
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
}