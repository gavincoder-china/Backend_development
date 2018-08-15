/*
        _                         _             
                                        (_)                       | |            
                     __ _   __ _ __   __ _  _ __    ___  ___    __| |  ___  _ __ 
                    / _` | / _` |\ \ / /| || '_ \  / __|/ _ \  / _` | / _ \| '__|
                   | (_| || (_| | \ V / | || | | || (__| (_) || (_| ||  __/| |   
                    \__, | \__,_|  \_/  |_||_| |_| \___|\___/  \__,_| \___||_|   
                     __/ |                                                       
                    |___/  


*/

package com.learn.常用类;

import java.util.Calendar;

public class CalendarDemo {

    public static void main(String[] args) {

        //     Calendar的创建不能使用new 要用getInstance（）方法
        Calendar calendar = Calendar.getInstance();

        //设置时间
        calendar.set(2018,12,12,12,12,12);
        System.out.println(calendar.get(Calendar.SECOND));
        int year = calendar.get(Calendar.YEAR);

        //获取月份，是从0开始的，需要加上一
        int month = calendar.get(Calendar.MONTH);
         //DAY_OF_MONTH  跟   DATE 没有区别
        int day = calendar.get(Calendar.DATE);
        System.out.println(day);
        int day1 = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(day1);
        int day2 = calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH);
        System.out.println(day2);
        //星期几，从周日开始算
        int day3 = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println(day3);

       /* int aa=10/0;
        System.out.println(aa);*/


    }
}
