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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class List遍历 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();

        list.add("java");
        list.add("c++");
        list.add("python");
        list.add("kotlin");
        list.add("julia");
        list.add("go");
        list.add("js.node");
        list.add("objectC");

        //集合遍历操作
        System.out.println("*******集合遍历for操作********");

        //这里的泛型选择器内，写的是你这个list的类型
        //如果是自定义对象，那这里面就写对象类型
        for (String string : list) {
            System.out.println(string);

        }
        // Iterator遍历器   这是个接口，不能直接new
        System.out.println("*******Iterator遍历器*******");


        //这里的泛型选择器内，写的是你这个list的类型
        //如果是自定义对象，那这里面就写对象类型
       Iterator<String> iterator=list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }




    }


}
