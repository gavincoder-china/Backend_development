package com.gavin.provider.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class Users implements Serializable {
    private Long id;

    private String name;

    private String password;

    private Integer age;

    private Integer sex;

    private Integer usertype;

    private Integer roleid;

    private String email;

    private Date bTime;

    private static final long serialVersionUID = 1L;
}