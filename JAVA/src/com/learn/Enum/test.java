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

package com.learn.Enum;


public class test {
    public static void main(String[] args) {

        int order = 0;
        if (order == EnumTest.WAIT_PAY.getOrderStatus()) {
            System.out.println(EnumTest.WAIT_PAY.getStatuString());
            System.out.println(EnumTest.WAIT_PAY.getPayall());
        } else if (order == EnumTest.PAID.getOrderStatus()) {
            System.out.println(EnumTest.PAID.getStatuString());
            System.out.println(EnumTest.PAID.getPayall());
        }

    }


}
