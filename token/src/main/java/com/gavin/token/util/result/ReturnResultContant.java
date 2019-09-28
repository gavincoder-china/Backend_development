package com.gavin.token.util.result;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-09-28 22:03
 * @description:
 ************************************************************/
public final class ReturnResultContant {

    // 把与前端交流的返回code写成静态常量,这边都是你自定义的(我的数据参考网上案例)

    // 通用情况
    //"success"
    public static final int SUCCESS = 0;
    //"服务端异常"
    public static int SERVER_EXCEPTION = 500100;
    //"输入参数为空"
    public static int PARAMETER_ISNULL = 500101;


    // 业务异常
    //"用户不存在"
    public static int USER_NOT_EXSIST = 500102;
    //"在线用户数超出允许登录的最大用户限制"
    public static int ONLINE_USER_OVER = 500103;
    //"不存在离线session数据"
    public static int SESSION_NOT_EXSIST =  500104;
    //"查找不到对应数据"
    public static int NOT_FIND_DATA = 500105;


}
