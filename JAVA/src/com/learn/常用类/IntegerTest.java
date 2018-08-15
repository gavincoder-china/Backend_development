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

public class IntegerTest {
    /**
     *拆箱：把封装类型数据转化为基本类型数据
     * 装箱：把基本类型数据转化为分装类型数据
     * */
     Integer b=3;
     int c=b;  //拆箱
     Integer a=c;   //装箱
    /*
     *常见的封装类型创建方法
     *
     *
     * */
    Integer first=3;

    Integer second=new Integer(1);
    Integer third=new Integer("123");//可传字符串必须是数字，不可是字母
    //方法已经过时，换下面的两种方法
    Integer forth=Integer.valueOf("1211hjb") ;//过时的替换方案
    Integer fifth=Integer.parseInt("1323") ;//可传字符串必须是数字，不可是字母


}
