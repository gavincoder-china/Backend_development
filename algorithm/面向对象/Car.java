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

public class Car {
   private String brand;
   private String price;

    public void run() {
        System.out.println("i can fly");
    }
    public static void main(String[] args) {
        Car car = new Car();
        car.brand = "bmw";
        car.price = "1";
        car.run();

    }


}
