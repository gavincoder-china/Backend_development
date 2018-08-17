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

package com.learn.File_IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class FileInputStreamDemo {

    public static void main(String[] args)  {
        FileOutputStream fileOutputStream = null;
        FileInputStream fileInputStream = null;
        try {
            // 1、创建输入流对,负责读取
            fileInputStream = new FileInputStream("D:\\Test.txt");
            // 2、创建输出流对象
            fileOutputStream = new FileOutputStream("D:\\Test2.txt");
            // 3、创建中转站数组,存放每次读取的内容
            byte[] words = new byte[1024];
            // 4、通过循环实现文件读取
            //fileInputStream.read()如果这个值返回为-1，则说明该文件已经没有数据可读了
            while ((fileInputStream.read()) != -1) {
                fileInputStream.read(words);
                fileOutputStream.write(words);
            }
            System.out.println("复制完成，请查看文件！");
        } catch (Exception e) {
            e.printStackTrace();
        }  finally {
            // 5、关闭流
            try {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}