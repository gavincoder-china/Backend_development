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



public class CardTalk extends CardPackage {
    private int CardTime=500;
    //private int CardFlow=0;
    private int CardSMS=30;
    private double CardPrice=58;



    @Override
    public void showInfo() {
        System.out.println("**********话痨套餐**********");
        System.out.println("\t\t\t通话时长："+CardTime+"分钟");
        System.out.println("\t\t\t短信条数"+CardSMS+"条");
        System.out.println("\t\t\t套餐资费"+CardPrice+"元/月");
        System.out.println("***************************");
    }
}
