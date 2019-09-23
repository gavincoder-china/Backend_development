package com.example.swagger.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@ApiModel
@Data
public class User {
    private Integer uid;
    @ApiModelProperty(value = "姓名",required = false)
    private String username;

    private String password;

    private Integer gender;
}