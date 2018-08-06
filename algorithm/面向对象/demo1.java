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

public class demo1 {
    public String PrintString(String a){

        System.out.println(a);

      return a;
    }

    public void mmm(){

        System.out.println("good" );

    }
    public static void main(String[] args) {
         String a="hello world";
         demo1 demo=new demo1();
         demo.PrintString(a);
         demo.mmm();
    }

}
