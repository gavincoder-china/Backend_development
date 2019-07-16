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

public class 三维数组遍历 {

    public static void main(String[] args) {

        int[][][] array = {{{1}, {32}}, {{1}}};
        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < array[i].length; j++) {

                for (int k = 0; k < array[i][j].length; k++) {
                    System.out.println(array[i][j][k]);
                }

            }


        }


    }
}
