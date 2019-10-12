package com.gavin.consumer.result;

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
public final class ReturnResultContants {

    // 把与前端交流的返回code写成静态常量,这边都是你自定义的(我的数据参考网上案例)

    // 通用情况
    //"success"
    public static final int SUCCESS = 0;
    //"服务端异常"
    public static final int SERVER_EXCEPTION = 500100;
    //"输入参数为空"
    public static final int PARAMETER_ISNULL = 500101;


    // 业务异常
    //"用户不存在"
    public static final int USER_NOT_EXSIST = 500102;

    // "在线用户数超出允许登录的最大用户限制"

    public static final int ONLINE_USER_OVER = 500103;

    //"不存在离线session数据"
    public static final int SESSION_NOT_EXSIST = 500104;

    //"查找不到对应数据"
    public static final int NOT_FIND_DATA = 500105;


    public static final int LOGIN_WRONG = 250;
    public static final int DEL_WRONG = 251;

    public static final int REGISTER_WRONG = 290;
    public static final int REGISTER_ALREADY_EXIST = 291;
    public static final int LOGIN_EXPIRE = 292;
    public static final int INTERCPTOR_LOGIN_ERROR = 293;

    public static final String MSG_WRONG_LOGIN = "登录失败";

    public static final String MSG_WRONG_REGISTER = "注册失败";


    public static final String MSG_REGISTER_ALREADY_EXIST = "该用户名已被注册";

    public static final String MSG_DEL_WRONG = "用户注销失败";

    public static final String MSG_LOGIN_EXPIRE = "登陆过期,需要重新登录";

    public static final String MSG_INTERCPTOR_LOGIN_ERROR = "未登录,请先登录";


}
