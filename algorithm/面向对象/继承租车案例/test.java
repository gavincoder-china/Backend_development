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

package 面向对象.继承租车案例;

import java.lang.reflect.Type;
import java.util.Scanner;

public class test {


    public static void main(String[] args) {


        System.out.println("欢迎您来到汽车租赁公司");
        Scanner scanner = new Scanner(System.in);

//
        //将车子信息放进数组
        MotoVehicle[] motos = new MotoVehicle[5];
        motos[0] = new Car("宝马", "七系", "金色", "苏A12345");
        motos[1] = new Car("别克", "商务车", "黑色", "苏A22222");
        motos[2] = new Car("别克", "林荫大道", "白色", "苏A33333");
        motos[3] = new Bus("金龙客车", "蓝色", 15, "苏A44444");
        motos[4] = new Bus("宇通客车", "灰色", 35, "苏A55555");
        System.out.println("我们现在可出租的车型有：");
         MotoVehicle moto=new MotoVehicle();
        //打印出现在可以出借的车型列表
        for (int i = 0; i < motos.length; i++) {
            System.out.print(i+1+"号车"+" ");
            moto.toS(motos[i]);
        }

        //这边我需要设置一个循环判断，保证客人可以多次选择，不仅选择车，还要选择不同车子租赁的时长
  int count = 0;
        for (int i = 1; i ==1; ) {
             //现在请输入您想要租赁的车型
            System.out.println("请在上列车型中选择您想要租赁的车，输入其对应的序号进行选择");
             int type=scanner.nextInt();
            //day是租赁的天数
            System.out.println("你输入您想要租赁的天数：");
            int day = scanner.nextInt();
             //现在将车型跟租赁天数带入计算金额的方法中
             //总租金
             count=count+moto.CalcRent(type,day);
            System.out.println("您现在的总租金为"+count);
             //做个判断，是否继续租车
            System.out.println("请问您是否想继续租车？按1继续，按任意键结束");
              i= scanner.nextInt();
              if(i==1){
                System.out.println("欢迎继续租车");
              }
              else {
                  System.out.println("感谢您的租赁，祝您生活愉快。");
              }
              
        }

    }
}
