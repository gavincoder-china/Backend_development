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
package 面向对象;

import java.util.Scanner;

public class SetGetTest {
    public static void main(String[] args) {
        SetGet setGet = new SetGet();
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        setGet.setName(name);
        setGet.setAge(18);
        setGet.setSex("man");
        System.out.println(setGet.getName());
        System.out.println(setGet.getAge());
        System.out.println(setGet.getSex());

    }
}
