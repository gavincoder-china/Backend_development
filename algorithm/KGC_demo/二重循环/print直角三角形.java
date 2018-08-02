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

import java.util.Scanner;

public class print直角三角形 {


    public static void main(String[] args) {
        System.out.print("请输入你要打印的行数：");
        Scanner  scanner=new Scanner(System.in);
        int cows=scanner.nextInt();
        System.out.println();
        for (int i = 1; i <=cows ; i++) {

            for (int j = 1; j <=(2*i-1); j++) {
                System.out.print("*");

            }
            System.out.println();


        }


    }
}
