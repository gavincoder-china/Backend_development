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

public class Bus  extends MotoVehicle{

    public int getSeatCount() {
        return SeatCount;
    }

    public void setSeatCount(int seatCount) {
        SeatCount = seatCount;
    }
     //构造函数
    public Bus(){};
    public Bus(String  Mileage, String   Color,int seatCount,String No) {
        this.setMileage(Mileage);
        this.setColor(Color);
        this.SeatCount=seatCount;
        this.setN(No);
    }

    private int SeatCount;

    @Override
    public int CalcRent(int type,int days) {
        int rent=0;
        if(type==5){
            rent=days*1500;
        }
                 else if(type==4){
                     rent=days*800;
        }
        else {
            System.out.println("对不起，您的输入有误，请重新选择");
        }
        return rent;
    }



}
