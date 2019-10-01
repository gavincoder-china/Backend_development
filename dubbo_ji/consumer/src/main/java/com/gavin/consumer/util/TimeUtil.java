package com.gavin.consumer.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-09-29 12:00
 * @description:
 ************************************************************/
public class TimeUtil {

    public Date stringToDate(Long time){

        String result1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(time * 1000));
        System.out.println("10位数的时间戳（秒）--->Date:" + result1);
        Date date1 = new Date(time*1000);
        return date1;
    }
}
