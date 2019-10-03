package com.example.consumer.exception;

/**
 * Created by boot on 2019/9/30.
 */
public class LoginException extends RuntimeException {

    private String msg;

    private LoginExceptionEnum loginExceptionEnum;

    public LoginException(LoginExceptionEnum businessEnum, String msg) {
        super(msg);
        this.msg = msg;
        this.loginExceptionEnum = businessEnum;
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
