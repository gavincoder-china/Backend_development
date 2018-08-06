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

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * 时间限制 1000 ms 内存限制 32768 KB 代码长度限制 100 KB 判断程序 Standard
 * 题目描述
 * 给定区间[-2的31次方, 2的31次方]内的3个整数A、B和C，请判断A+B是否大于C。
 *
 * 输入描述:
 * 输入第1行给出正整数T(<=10)，是测试用例的个数。随后给出T组测试用例，每组占一行，顺序给出A、B和C。整数间以空格分隔。
 *  无力吐槽，这边竟然是让我自己输入测试数字//我以为是自动生成随机数
 *
 * 输出描述:
 * 对每组测试用例，在一行中输出“Case #X: true”如果A+B>C，否则输出“Case #X: false”，其中X是测试用例的编号（从1开始）。
 *
 * 输入例子:
 * 4
 *
 * 1 2 3
 *
 * 2 3 4
 *
 * 2147483647 0 2147483646
 *
 * 0 -2147483648 -2147483647
 *
 * 输出例子:
 * Case #1: false
 *
 * Case #2: true
 *
 * Case #3: true
 *
 * Case #4: false
 */






public class AB和C {


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
         int time=0;
        long A,B,C;
        A=B=C=0;
        int i=0;
        time=sc.nextInt();
       while (i++<time){

            A=sc.nextLong();
            B=sc.nextLong();
           C=sc.nextLong();

          


           if((A+B)>C){
               System.out.println("Case #"+i+": true");
           }
           else {
               System.out.println("Case #"+i+": flase");

           }
        }



    }

    
}
