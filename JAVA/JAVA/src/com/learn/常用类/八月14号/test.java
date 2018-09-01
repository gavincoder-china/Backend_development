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

package com.learn.常用类.八月14号;

public class test {

    public static void main(String[] args) {
        //测试去除字符串空格
        String s= "  nss shx ";
        去除字符串内所有空格 qu=new 去除字符串内所有空格();
        String str=qu.trimAll(s);
        System.out.println(str);
         // 测试显示日历
        Calendar calendar=new Calendar();
        calendar.timeData();

    }



}
