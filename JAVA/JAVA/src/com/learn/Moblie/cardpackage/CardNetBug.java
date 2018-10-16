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

package com.learn.Moblie.cardpackage;

public class CardNetBug extends CardPackage {

    //private int CardTime=0;
    
    private int CardFlow=3*1024;
    //private int CardSMS=0;
    private double CardPrice=68;

    @Override
    public void showInfo() {
        System.out.println("**********网虫套餐**********");
        System.out.println("\t\t\t上网流量："+CardFlow/1024+"GB");
        System.out.println("\t\t\t套餐资费"+CardPrice+"元/月");
        System.out.println("***************************");
    }
}
