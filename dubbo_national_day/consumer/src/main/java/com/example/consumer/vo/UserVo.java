package com.example.consumer.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-10-02 16:03
 * @description:
 ************************************************************/
@Data
public class UserVo implements Serializable {


    private static final long serialVersionUID = 1049505423021472219L;

    private String userName;


    private String password;


    private Integer uLevel;

    private int startPage;

    private int pageSize;




}
