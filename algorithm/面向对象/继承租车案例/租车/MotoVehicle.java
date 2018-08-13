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

package 面向对象.继承租车案例.租车;

public abstract class MotoVehicle {
    private  String type;
    private  String color;
    private  String No;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNo() {
        return No;
    }

    public void setNo(String no) {
        No = no;
    }

    public  abstract int calcRent(int days);

    public  int calAllRent(MotoVehicle[] motos,int days){
        int Allrent=0;
        for (int i = 0; i <motos.length ; i++) {
            MotoVehicle vehicle=motos[i];
            int rentmoney=vehicle.calcRent(days);
            Allrent+=rentmoney;
        }
               return  Allrent;
    }


}
