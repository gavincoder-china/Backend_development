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

import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.function.DoubleBinaryOperator;

public class 闰年计算 {


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("请输入year：");
        int year = scan.nextInt();
        System.out.println("请输入month：");
        int month = scan.nextInt();
        System.out.println("请输入day：");
        int day = scan.nextInt();
        int array_month[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};


        boolean flag = ((((year % 4) == 0) && (year % 100) != 0) || ((year % 400) == 0));
        if (flag) {

            array_month[1] = 29;    //闰年
        }

        int sumday = 0;
        for (int i = 0; i < (month - 1); i++) {

            sumday = sumday + array_month[i];
        }
        sumday = sumday + day;
        System.out.println(year + "年" + month + "月" + day + "日,是本年第" + sumday + "天");
        
    }
}
