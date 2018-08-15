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

import java.util.Random;

public class MathDemo {
    public static void main(String[] args) {
        Random random=new Random();

        for (int i = 0; i <100 ; i++) {

            System.out.println(random.nextInt(10));
            System.out.println(random.nextBoolean());
        }

    }


}
