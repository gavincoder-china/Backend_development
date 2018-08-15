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

package com.learn.继承租车案例;

public class Car  extends MotoVehicle{
      //品牌
      private String Brand;
      //型号
      private String type;

      public String getBrand() {
            return Brand;
      }

      public void setBrand(String brand) {
            Brand = brand;
      }

      public String getType() {
            return type;
      }

      public void setType(String type) {
            this.type = type;
      }

      //构造函数

      public Car() {

      }

      public Car(String Brand, String type, String Color, String No){
                   this.Brand=Brand;
                   this.type=type;
                   super.setColor(Color);
                   super.setN(No);

      }


      @Override
      public int CalcRent(int type,int days) {
               int rent=0;
               switch(type) {
                     case 1:
                           rent=500*days;
                           return rent;
                     case 2:
                           rent=600*days;
                           return rent;
                     case 3:
                           rent=300*days;
                           return rent;
                      default:
                            System.out.println("对不起，您的输入有误，请重新选择");
                            return rent;








               }



      }
      //      public int getBrand( ) {
//            return Brand;
//      }
//      public void setBrand(int brand) {
//            Brand = brand;
//            //在品牌设置好之后，判断是否为别克，因为别克还有其他车型
//            if(brand==2){
//                  System.out.println("请选择别克车的具体类型：2、商务车 3、林荫大道");
//                  Scanner scanner=new Scanner(System.in);
//                  this.setType(scanner.nextInt());
//            }
//      }
//
//      public int getType() {
//            return type;
//      }
//
//      public void setType(int type) {
//            this.type = type;
//      }
//      @Override
//      public void CalcRent(int days) {
//           float rent;
//            if(Brand==1){
//                  rent=days*500;
//            }
//            else {
//
//                  if(type==2){
//                        rent=days*600;
//                  }
//                  else {
//                        rent=days*300;
//                  }
//            }
//            System.out.println("您的总租金为"+rent);
//      }
//

}
