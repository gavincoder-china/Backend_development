package com.learn.循环;/*
        _                         _             
                                        (_)                       | |            
                     __ _   __ _ __   __ _  _ __    ___  ___    __| |  ___  _ __ 
                    / _` | / _` |\ \ / /| || '_ \  / __|/ _ \  / _` | / _ \| '__|
                   | (_| || (_| | \ V / | || | | || (__| (_) || (_| ||  __/| |   
                    \__, | \__,_|  \_/  |_||_| |_| \___|\___/  \__,_| \___||_|   
                     __/ |                                                       
                    |___/  


*/

public class 九九乘法表 {

    public static void main(String[] args) {

        for (int i = 1; i <= 9; i++) {

            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + j * i+"\t");
                  /*\t制表符很厉害*/


            }

            System.out.println();


        }


    }
}
