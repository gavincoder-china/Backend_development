package com.learn.数组;/*
        _                         _             
                                        (_)                       | |            
                     __ _   __ _ __   __ _  _ __    ___  ___    __| |  ___  _ __ 
                    / _` | / _` |\ \ / /| || '_ \  / __|/ _ \  / _` | / _ \| '__|
                   | (_| || (_| | \ V / | || | | || (__| (_) || (_| ||  __/| |   
                    \__, | \__,_|  \_/  |_||_| |_| \___|\___/  \__,_| \___||_|   
                     __/ |                                                       
                    |___/  


*/

public class 倒序排序 {

    public static void main(String[] args) {
        int[] array = {2, 5, 3, 6, 7, 1, 9, 1, 2, 99, 88};

          倒序排序.sort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    

    public static int[] sort(int[] array){


        for (int i = 0; i < array.length; i++) {


            for (int j = i + 1; j < array.length; j++) {


                if (array[j] > array[i]) {
                   int  temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;

                }

            }
        }

         return  array;

    }








}
