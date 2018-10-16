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

package com.learn.Moblie;

import java.sql.SQLOutput;

/***
 * @Description： 这边是移动卡用户的使用信息
卡号：CardNumber
用户名：userName
密码：Password
所属套餐：WhatPackage
当月消费金额：ConsumAll
张账户余额：RemainMoney
当月实际通话时长：RealTalkTime、
当月实际上网流量：RealInternetFlow
当月实际发送短信条数：RealSMSCount


 * @Param:
 * @Return:
 * @Auther: Gavincoder
 * @Date: 2018/9/16
 */
public class CardPersonInfo {
    private int CardNumber;
    private String userName;
    private String Password;

    private String WhatPackage;
    private double ConsumAll;
    private double RemainMoney;
    private int RealTalkTime=0;
    private int RealInternetFlow=0;
    private int RealSMSCount=0;

    public int getCardNumber() {
        return CardNumber;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return Password;
    }

    public String getWhatPackage() {
        return WhatPackage;
    }

    public double getConsumAll() {
        return ConsumAll;
    }

    public double getRemainMoney() {
        return RemainMoney;
    }

    public void setCardNumber(int cardNumber) {
        CardNumber = cardNumber;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setWhatPackage(String whatPackage) {
        WhatPackage = whatPackage;
    }

    public void setConsumAll(double consumAll) {
        ConsumAll = consumAll;
    }

    public void setRemainMoney(double remainMoney) {
        RemainMoney = remainMoney;
    }

    public void setRealTalkTime(int realTalkTime) {
        RealTalkTime = realTalkTime;
    }

    public void setRealInternetFlow(int realInternetFlow) {
        RealInternetFlow = realInternetFlow;
    }

    public void setRealSMSCount(int realSMSCount) {
        RealSMSCount = realSMSCount;
    }

    public int getRealTalkTime() {
        return RealTalkTime;
    }

    public int getRealInternetFlow() {
        return RealInternetFlow;
    }

    public int getRealSMSCount() {
        return RealSMSCount;
    }
     public void ShowInfo(){

         System.out.println("卡号："+getCardNumber());
         System.out.println("用户名："+getUserName());
         System.out.println("密码："+getPassword());
         System.out.println("所属套餐："+getWhatPackage());
         System.out.println("当月消费金额："+getConsumAll());
         System.out.println("账户余额："+getRemainMoney());
         System.out.println("当月实际通话时长："+getRealTalkTime());
         System.out.println("当月实际上网流量："+getRealInternetFlow());
         System.out.println("当月实际发送短信条数："+getRealSMSCount());
     }



}
