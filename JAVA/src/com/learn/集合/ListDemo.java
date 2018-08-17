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

package com.learn.集合;

import com.learn.循环.print直角三角形;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        List list = new ArrayList();
        //ArrayList list=new ArrayList();   两种写法，是一样的
        list.add(1);
        //在下标1处添加
        list.add(1,"张三");
        //可以传入对象
        list.add(new print直角三角形());
        //获得下标对应的对象
        list.get(0);
        list.remove("张三");
        //判断是否在其中
        System.out.println(list.contains(1));
        //长度
        System.out.println(list.size());


    }


}
