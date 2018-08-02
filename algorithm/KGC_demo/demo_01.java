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

import com.sun.jdi.PathSearchingVirtualMachine;

import java.sql.SQLOutput;
import java.text.BreakIterator;
import java.time.Year;
import java.util.Random;
import java.math.*;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

public class demo_01 {


    public static void main(String[] args) {


        String array[] = {"1、朱明雄", "2、乔鹏", "3、孙瑞涵", "4、范君", "5、徐宏涛", "6、王啸翀", "7、黄可", "8、陈威", "9、刘硕", "10、艾京", "11、魏国家","12、王少军"};
        Scanner scanner = new Scanner(System.in);
        for (int j = 0; j < array.length; j++) {


            for (int i = 1; i != 0; ) {

                int array_choice = (int) (Math.random() * 12);
                if (array[array_choice] != "none") {
                    System.out.println(array[array_choice]);
                    i = 0;
                    array[array_choice] = "none";
                } else {
                    array_choice = (int) (Math.random() * 11);
                }

            }
            System.out.println("你是否想继续抽号？想继续请按1：");
            int flag = scanner.nextInt();
            if (flag==1) {

                continue;
            }
            j=array.length;
            System.out.println("抽号结束");
        }
    }
}
