package com.gavin.consumer.exception;


import lombok.Data;

@Data
public class LoginException extends RuntimeException {

    private String msg;
    private int code;

    private LoginExceptionEnum loginExceptionEnum;

    public LoginException(LoginExceptionEnum businessEnum) {


        this.msg=businessEnum.getMsg();
        this.code=businessEnum.getCode();
    }



    public LoginException(LoginExceptionEnum businessEnum, String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.loginExceptionEnum = businessEnum;
    }


    public LoginExceptionEnum getLoginExceptionEnum() {
        return loginExceptionEnum;
    }

    public void setLoginExceptionEnum(LoginExceptionEnum loginExceptionEnum) {
        this.loginExceptionEnum = loginExceptionEnum;
    }

}
