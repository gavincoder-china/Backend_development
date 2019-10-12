package com.gavin.consumer.exception;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-10-08 11:08
 * @description:
 ************************************************************/


public class LoginExceptionUtil {

    private LoginException loginException;

    public LoginException getLoginException() {
        return loginException;
    }

    public void setLoginException(LoginException loginException) {
        this.loginException = loginException;
    }

    private String buildExceptionJSON(LoginException le){

        LoginExceptionEnum enums = le.getLoginExceptionEnum();
        return  "{'code':"+ enums.getCode()+",'message':'     "+enums.getMsg()+"'}";
    }


}
