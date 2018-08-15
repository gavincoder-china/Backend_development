package com.learn.常用类.八月14号;

public enum CalendarEnum {
    SUN(0,"星期天"),
    MON(1,"星期一"),
    TUE(2,"星期二"),
    WES(3,"星期三"),
    THU(4,"星期四"),
    FIR(5,"星期五"),
    STA(6,"星期六");
    private int a;
    private String s;

    CalendarEnum(int a,String s) {
          this.a=a;
          this.s=s;


    }

    public int getA() {
        return a;
    }

    public String getS() {
        return s;
    }
}
