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

package com.learn.面向对象;

public class Cat extends Pet {


    @Override
    public void eat() {
        System.out.println("我吃鱼");
    }
    public  void test(){
        super.eat();
        this.eat();


    }

    public static void main(String[] args) {
       Cat cat=new Cat();
       cat.test();
    }

}
