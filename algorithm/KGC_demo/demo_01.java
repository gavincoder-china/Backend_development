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
import java.util.Random;
import java.math.*;

public class demo_01 {


    public static void main(String[] args) {
        int a = (int) (Math.random() * 10);

        switch (a) {

            case 1:
                System.out.println("1、朱明雄");
                break;
            case 2:
                System.out.println("2、乔鹏");
                break;
            case 3:
                System.out.println("3、孙瑞涵");
                break;
            case 4:
                System.out.println("4、范君");
                break;
            case 5:
                System.out.println("5、徐宏涛");
                break;
            case 6:
                System.out.println("6、王啸翀");
            case 7:
                System.out.println("7、黄可");
                break;
            case 8:
                System.out.println("8、陈威");
                break;
            case 9:
                System.out.println("9、刘硕");
                break;

        }


        String array[] = {"1、朱明雄", "2、乔鹏", "3、孙瑞涵", "4、范君", "5、徐宏涛", "6、王啸翀", "7、黄可", "8、陈威", "9、刘硕"};

        int array_choice = (int) (Math.random() * 9);
        System.out.println(array[array_choice]);




        





    }
}
