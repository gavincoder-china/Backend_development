package com.example.consumer.exception;


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



    public LoginExceptionEnum getBusinessEnum() {

        return loginExceptionEnum;
    }


    public void setBusinessEnum(LoginExceptionEnum businessEnum) {

        this.loginExceptionEnum = businessEnum;
    }


}
