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

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {

    public static void main(String[] args) {
        Map<String,String> map=new HashMap();
        map.put("1","张三") ;
        map.put("2","李四") ;
        map.put("3","王二") ;
        //key值是唯一的，会覆盖
        map.put("1","gavin") ;
        System.out.println(map.get("1"));
        //删除一个key及其对应的值
        map.remove(1) ;
        System.out.println(map.containsKey(1));
        System.out.println(map);
        System.out.println(map.size());


         //把key作为集合传出
        System.out.println(map.keySet());
//        Set set=map.keySet();

        //把值作为集合传出

        System.out.println(map.values());
//        Collection collection=map.values();

    }
}
