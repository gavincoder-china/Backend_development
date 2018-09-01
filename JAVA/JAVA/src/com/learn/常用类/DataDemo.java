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

//import javax.xml.crypto.Data;
import java.util.Date;
//import java.util.logging.SimpleFormatter;
import java.text.SimpleDateFormat;

public class DataDemo {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        /** SimpleDateFormat    import java.text.SimpleDateFormat;
         *   yyyy指年份占位符（year）
         *   MM（大写）指月份占位符
         *   dd指天的占位符
         *   hh/HH指小时的占位符，大写指二十四小时占位符，小写指十二小时
         *   mm指分钟占位符
         *   ss指秒钟的占位符
         *
         * */
        //格式化时间
        SimpleDateFormat Format = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        System.out.println(Format.format(date));
    }


}
