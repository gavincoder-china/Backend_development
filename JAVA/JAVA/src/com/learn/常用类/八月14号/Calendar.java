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

package com.learn.常用类.八月14号;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Calendar {
    java.util.Calendar calendar = java.util.Calendar.getInstance();
    Date date = new Date();
    SimpleDateFormat Format = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");

    String week() {
        switch (calendar.get(java.util.Calendar.DAY_OF_WEEK)) {
            case 0:
                return CalendarEnum.SUN.getS();

            case 1:
                return CalendarEnum.MON.getS();
           // break;
            case 2:
                return CalendarEnum.TUE.getS();
           // break;
            case 3:
                return CalendarEnum.WES.getS();
           // break;
            case 4:
                return CalendarEnum.THU.getS();
           // break;
            case 5:
                return CalendarEnum.FIR.getS();
           // break;
            case 6:
                return CalendarEnum.STA.getS();
            //break;
            default:
                return null;

        }


    }

    public void timeData() {


        System.out.println("现在是北京时间" + Format.format(date) + "今天是"+" "+this.week());


    }


}
