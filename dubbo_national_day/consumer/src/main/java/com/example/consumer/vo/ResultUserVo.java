package com.example.consumer.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-10-02 21:15
 * @description:
 ************************************************************/
@Data
public class ResultUserVo implements Serializable {
    private static final long serialVersionUID = 5262301910632892569L;

    private Integer id;


    private String userName;



    private Date bTime;


    private Integer uType;

    private Integer uLevel;

}
