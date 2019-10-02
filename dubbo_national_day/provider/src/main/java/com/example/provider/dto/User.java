package com.example.provider.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
public class User implements Serializable {
    private static final long serialVersionUID = 4010513523002748544L;

    private Integer id;


    private String userName;


    private String password;

    private Date bTime;


    private Integer uType;

    private Integer uLevel;

    private Integer start;

    private Integer offset;


}