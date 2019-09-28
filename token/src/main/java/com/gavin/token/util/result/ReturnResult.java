package com.gavin.token.util.result;

import java.io.Serializable;


/**
 * **********************************************************
 *
 * @Project:   和前端接口交互的统一格式  返回结果集类
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-09-28 22:03
 * @description:
 ************************************************************/
public class ReturnResult<T> implements Serializable{


    //状态码
    private Integer code;
    //提示信息
    private String message;
    //返回数据
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
