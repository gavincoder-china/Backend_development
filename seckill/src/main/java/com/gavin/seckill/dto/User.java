package com.gavin.seckill.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class User implements Serializable {
    private Long id;

    private String account;

    private String phone;

    private String email;

    private Byte gender;

    private String nickname;

    private String headImgUrl;

    private Byte role;

    private Integer level;

    private Date createTime;

    private String country;

    private String province;

    private String city;

    private static final long serialVersionUID = 1L;
}