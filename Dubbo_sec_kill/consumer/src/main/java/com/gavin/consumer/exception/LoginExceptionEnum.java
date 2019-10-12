package com.gavin.consumer.exception;


public enum LoginExceptionEnum {

    /**
     *
     */
    LOGIN_FAIL_ECPTION(101, "登录失败!");

    private int code;
    private String msg;

    LoginExceptionEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {

        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}
