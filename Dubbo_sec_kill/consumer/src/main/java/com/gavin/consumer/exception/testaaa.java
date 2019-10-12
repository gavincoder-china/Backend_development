package com.gavin.consumer.exception;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-10-08 11:14
 * @description:
 ************************************************************/
public class testaaa {
    public static void main(String[] args) {

        try {
            throw new LoginException(LoginExceptionEnum.LOGIN_FAIL_ECPTION);
        }
        catch (LoginException e) {

            LoginExceptionEnum enums = e.getLoginExceptionEnum();
            System.out.println("{'code':" + enums.getCode() + ",'message':'  " +
                               "   " + enums.getMsg() + "'}");


        }


    }
}
