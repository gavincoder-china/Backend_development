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

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Map遍历 {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "张三");
        map.put(2, "李四");
        map.put(3, "王二");


        System.out.println("*********第一种遍历方法*使用for  each遍历 keyset*********");
        /*使用for  each遍历 keyset
         * */

        //Set<Integer>  set=map.keySet();
        for (Integer key : map.keySet()) {
            System.out.println("key=" + key + "value=" + map.get(key));
        }


        System.out.println("*********第二种遍历方法*使用interator遍历keyset*********");
        /*
         *使用interator遍历keyset
         * */

        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
           //这边一定要给  iterator.next()传入一个参数，不然在后面调用值会变化
            //比如     "key=" + iterator.next() + 这边的key值是没问题的
            //                    "value=" + map.get(iterator.next()))
            // 这边传入的key值因为上一句的调用后已经返回后面一个了，这就会导致错位
            Integer p1=iterator.next();
            System.out.println("key=" + p1 +
                    "value=" + map.get(p1));
        }


        System.out.println("*********第三遍历方法*使用for  each来遍历entrySet*********");
        /*
         * 使用for  each来遍历entrySet
         *
         * */
//        for (Map.Entry<Integer, String> entry : map.entrySet()) {
//            System.out.println("key=" + entry.getKey() + "value=" + entry.getValue());
//        }
        for(Map.Entry entry:map.entrySet()){
            System.out.println("key=" + entry.getKey() + "value=" + entry.getValue());
        }
        System.out.println("*********第四种遍历方法*使用interator 来遍历entrySet*********");
        /*
         *  使用interator 来遍历entrySet
         * */
        Iterator<Map.Entry<Integer, String>> iterator1 = map.entrySet().iterator();

        while (iterator1.hasNext()) {
            Map.Entry<Integer,String> p2 =  iterator1.next();
            System.out.println("key=" + p2.getKey() + "value=" + p2.getValue());
        }


    }


}
