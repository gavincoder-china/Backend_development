package com.gavin.consumer.vo;

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
 * @Date : 2019-09-29 09:09
 * @description:
 ************************************************************/
@Data
public class UserVo implements Serializable {

    private String userName;

    private String password;

    private PageVo pageVo;

    private int level;


}
