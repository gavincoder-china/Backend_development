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

package com.learn.常用类;

public class StringDemo {


    /**
     * String中常用的方法
     * length() 得到字符长度
     * string--->char[]
     * equalsIgnoreCase,比较字符串内容，忽略大小写
     * 将字符串转化为大小写   toUpperCase  toLowerCase
     * string的拼接方法contact()
     * indexOf（）表示某个字符或字符串在字符串中出现的位置
     * lastindexOf（）表示最后一次出现的位置
     * <p>
     * trim（）表示去除字符串两端的空格   testString.trim().length()
     * split(分割)  将字符串按照分割点分割成数组
     */

    public static void main(String[] args) {
        String testString = "marry";

        //得到其字符串数组的长度
        System.out.println(testString.trim().length());
        //忽略大小写，判断其内容是否一致
        System.out.println(testString.equalsIgnoreCase("mARRY"));
        //全部改为小写


        System.out.println(testString.toLowerCase());
        //全部改为大写
        System.out.println(testString.toUpperCase());
        //在原有字符串后面连接上新的字符串，组成一个新的字符串
        System.out.println(testString.concat("HONOR"));
    }
     /*
     * /*
 * java可以使用两种方法直接将字符数组转为字符串
 * 方法1：直接在构造String时转换。
   char[] data = {'a', 'b', 'c'};
   String str = new String(data);
 * 方法2：调用String类的方法转换。
   String.valueOf(char[] ch)
 *
 * java可以使用两种方法直接将字符串转为字符数组
 * 情况一：如果是有分隔符的那种例如"abc,def,ghi";就直接分割就行了.
	String string = "abc,def,ghi";
	String [] strArr= string.split(",");  //注意分隔符是需要转译
 * 情况二：如果是"abcdefghijk"这种字符串,就直接
	String string1 = "abcdefghijk" ;
	char [] strArr1 = string1.toCharArray(); //注意返回值是char数组
 */
   /*  public class 字符类型转换 {

         public static void main(String[] args) {
             // TODO Auto-generated method stub
             // 将字符数组转为字符串
             // 方法一
             char[] data = { 'a', 'b', 'c' };// 字符数组
             String str = new String(data);
             System.out.println(str);
             // 方法二
             String str1 = String.valueOf(data);
             System.out.println(str1);

             // 将字符串转为字符串数组
             // 方法一
             String string = "abc,def,ghi";
             String[] strArr = string.split(",");//注意分隔符是需要转译
             for (int i = 0; i < strArr.length; i++) {
                 System.out.println(strArr[i]);
             }
             // 方法二
             String string1 = "abcdefghijk";
             char[] strArr1 = string1.toCharArray();
             for (int i = 0; i < strArr1.length; i++) {
                 System.out.println(strArr1[i]);
             }

         }

     }*/


}
