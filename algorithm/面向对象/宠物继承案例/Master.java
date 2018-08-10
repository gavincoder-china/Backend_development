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

package 面向对象.宠物继承案例;

public class Master {

    public static void main(String[] args) {
        Dog dog=new Dog();
        System.out.println(dog.toString());
        dog.feed(dog);
        System.out.println(dog.toString());
        System.out.println("--------------");
        dog.play(dog);
        

    }
}
