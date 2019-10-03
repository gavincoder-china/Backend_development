package com.gavin.token.util.result;


/**
 * **********************************************************
 *
 * @Project:   返回结果集类的工具类
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-09-28 22:03
 * @description:
 ************************************************************/
public class ReturnResultUtils{

    /***
     * 成功 不带数据
     * @return  返回状态码与状态信息
     */
    public static ReturnResult returnSuccess(){
        ReturnResult returnResult=new ReturnResult();
        returnResult.setCode(ReturnResultContants.SUCCESS);
        returnResult.setMessage("success");
        return returnResult;
    }
    /***
     * 成功 带数据
     * @return  返回状态码,状态信息与数据
     */
    public static ReturnResult returnSuccess(Object data){
        ReturnResult returnResult=new ReturnResult();
        returnResult.setCode(ReturnResultContants.SUCCESS);
        returnResult.setMessage("success");
        returnResult.setData(data);
        return returnResult;
    }


    /***
     * 成功 带数据
     * @return  返回状态码,状态信息与数据(自定义)
     */
    public static ReturnResult returnSuccess(Integer code, String message,Object data){
        ReturnResult returnResult=new ReturnResult();

        returnResult.setCode(code);
        returnResult.setMessage(message);
        returnResult.setData(data);
        return returnResult;
    }
    /***
     * 失败
     * @return  返回状态码与状态信息
     */
    public static ReturnResult returnFail(Integer code, String message){
        ReturnResult returnResult=new ReturnResult();
        returnResult.setCode(code);
        returnResult.setMessage(message);
        return returnResult;
    }

}
