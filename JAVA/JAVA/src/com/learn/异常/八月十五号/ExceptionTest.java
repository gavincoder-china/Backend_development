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

package com.learn.异常.八月十五号;

//import java.util.logging.Logger; 不是引入这个包

import org.apache.log4j.Logger;

import java.util.Scanner;

public class ExceptionTest {
    private final static Logger LOGGER = Logger.getLogger(ExceptionTest.class);

    private int num; //被除数
    private int num2;    //除数

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    private void confirm(int num, int num2) throws ExceptionDEMO {
        if (num2 == 0) {
            throw new ExceptionDEMO("被除数和除数必须是整数，除数不能为0");
        }
    }


    public static void main(String[] args) {
        ExceptionTest exceptionTest = new ExceptionTest();
        Scanner scanner = new Scanner(System.in);
       // LOGGER.setUseParentHandlers(false);
        try {
            System.out.println("请输入被除数");
            exceptionTest.setNum(scanner.nextInt());
            LOGGER.info("被除数是:"+exceptionTest.getNum());
            System.out.println("请输入除数");
            exceptionTest.setNum2(scanner.nextInt());
            LOGGER.info("除数是:"+exceptionTest.getNum2());

            exceptionTest.confirm(exceptionTest.getNum(), exceptionTest.getNum2());
        } catch (Exception e) {
            e.printStackTrace();

            LOGGER.error("被除数和除数必须是整数，除数不能为0");

        }


    }


}
