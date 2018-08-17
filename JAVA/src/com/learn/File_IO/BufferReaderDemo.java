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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//这边的代码是utf-8格式，但是计算机是GBK格式，所以会出现乱码现象，莫大惊小怪
public class BufferReaderDemo {


    public static void main(String[] args) throws Exception {
        FileReader fileReader = null;


        try {
            fileReader = new FileReader("d:\\test.txt");


            BufferedReader br = new BufferedReader(fileReader);
            String length = br.readLine();
            while (length != null) {
                System.out.println(length);
                length = br.readLine();

            }

        } catch (Exception e) {

        }
    }
}