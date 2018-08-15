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

package com.learn.异常;


/**
 * @Description： 无论是否抛出异常，finally代码块总是会被执行。
 * 就算是没有catch语句同时又抛出异常的情况下，finally代码块仍然会被执行。
 * 最后要说的是，finally代码块主要用来释放资源，比如：I/O缓冲区，数据库连接。
 * @Param:
 * @Return:
 * @Auther: Gavincoder
 * @Date: 2018/8/15
 */

public class ExceptionErrorDemo {
     private Integer age;



    public String str() throws Exception {
        int[] a = {1, 2, 3, 4, 5};
        System.out.println(a[5]);
        return "这里是我的测试方法";
    }


    public void setage(Integer age) throws MyException{

        if(age<18){
              throw new MyException("不能小于18岁");
          }
          else if(age>100){
              throw new MyException("不能大于100岁");

          }
          else {
            this.age=age;
          }
    }
    public static void main(String[] args) {

      /*  Scanner scanner = new Scanner(System.in);
        Integer a = null;
        try {
            a = scanner.nextInt();
        } catch (Exception e) {
         e.printStackTrace();
            System.out.println("error");
        } finally {
            System.out.println("final");
        }

        System.out.println("end");*/
      /*  ExceptionErrorDemo exceptionErrorDemo = new ExceptionErrorDemo();
        try {
            exceptionErrorDemo.str();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("ok");
        }*/
      ExceptionErrorDemo exceptionErrorDemo=new ExceptionErrorDemo();

        try {
            exceptionErrorDemo.setage(15);
        } catch (MyException e) {
            e.printStackTrace();
        } finally {

            
        }


    }


}
