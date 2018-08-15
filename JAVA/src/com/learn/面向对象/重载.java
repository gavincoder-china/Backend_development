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

public class 重载 {
    /* 方法的重载：
           存在原因：因为方法名的杂乱性，需要同样的方法名，但是其中方法需要重新定义。
        方法重载的相关因素：
          能够实现重载：（在下面我会展示出来）
             ①参数个数
             ②参数类型
             ③参数位置
          无关的因素：
            ① 访问修饰符
            ②返回类型

            */

    public  void  test(){
        System.out.println("我是原方法");
    }
    public  void  test(int a){
        System.out.println("我是重载方法，改变参数");
    }
    public  void  test(int a, String b){
        System.out.println("我是重载方法，改变参数的个数");
    }
    public  void  test(String b,int a){
        System.out.println("我是重载方法，改变参数的位置");
    }
}
