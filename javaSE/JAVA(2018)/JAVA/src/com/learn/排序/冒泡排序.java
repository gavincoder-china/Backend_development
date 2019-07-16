package com.learn.排序;/*
        _                         _             
                                        (_)                       | |            
                     __ _   __ _ __   __ _  _ __    ___  ___    __| |  ___  _ __ 
                    / _` | / _` |\ \ / /| || '_ \  / __|/ _ \  / _` | / _ \| '__|
                   | (_| || (_| | \ V / | || | | || (__| (_) || (_| ||  __/| |   
                    \__, | \__,_|  \_/  |_||_| |_| \___|\___/  \__,_| \___||_|   
                     __/ |                                                       
                    |___/  


*/

import java.util.Arrays;

public class 冒泡排序 {
    /*字符串冒泡排序*/

    public static void main(String[] args) {

        String[] array = {"bbb", "aaa", "eee", "ddd", "ccc"};

        for (int i = 0; i < array.length-1; i++) {
            /*由于不需要比较自身，所以只要比较length-1次*/


            for (int j = i + 1; j < array.length; j++) {

                if (((array[j]).compareTo((array[i])) >0)) {
                    //字符串的比较是真的坑
                    String temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }


        System.out.println(Arrays.toString(array));
        /*输出字符串*/
    }


}
