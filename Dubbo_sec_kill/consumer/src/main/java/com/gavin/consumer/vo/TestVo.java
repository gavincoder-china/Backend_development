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
 * @Date : 2019-10-12 16:50
 * @description:
 ************************************************************/
@Data
public class TestVo implements Serializable {


    private static final long serialVersionUID = -5837033247998082925L;

    private String name;
    private int age;
}
