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

package com.learn.常用类.八月14号;

public class 去除字符串内所有空格 {
        /**
        * 将字符串转化为数组，然后遍历数组
        * 如果不是空，就将其接到一个新字符串后
        * */
      public String trimAll(String args){
            //先将字符串转化为char型数组
          char[] strarray=args.toCharArray();

          //可以正阳来初始化一个空字符串
          String  str="";
       ///   System.out.println(str);
          for (int i = 0; i <strarray.length ; i++) {
              //这边的char比较用的ascii码，space对应的码值是32
                if(strarray[i]!=32){
                    str=str+(strarray[i]);
                }
          }


             return str;

      }



}
