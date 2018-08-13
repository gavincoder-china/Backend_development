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

public   class MotoVehicle {
    //型号
    private String  Mileage;
    //颜色
    private String   Color;
    //车牌
    private String No;



     //计算租金
    public  int CalcRent(int type,int days){
        int rent=0;
        if(type==1||type==2||type==3){
            Car car =new Car();
            rent=car.CalcRent(type,days);
        }   else if(type==4||type==5){
            Bus bus=new Bus();
            rent=bus.CalcRent(type,days);
        }   else {
            System.out.println("对不起，您的输入有误，请重新选择");

        }
          return rent;

    }


    public String getNo() {
        return No;
    }

    public void setN(String no) {
        No = no;
    }



    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getMileage() {
        return Mileage;
    }

    public void setMileage(String mileage) {
        Mileage = mileage;
    }

    public void toS(MotoVehicle motoVehicle) {
        String printString;
        if(motoVehicle instanceof Car){
             Car car=(Car)motoVehicle;
             printString=car.getBrand()+"\t"+car.getType()+"\t"+car.getColor()+"\t"+car.getNo();
         }else if(motoVehicle instanceof  Bus){

            Bus bus=(Bus)motoVehicle;
            printString=bus.getMileage()+"\t"+bus.getColor()+"\t"+bus.getSeatCount()+"\t"+bus.getNo();
        }
        else {
            printString=null;
            System.out.println("对不起，您的输入有误");

        }
        System.out.println(printString);
    }
}
