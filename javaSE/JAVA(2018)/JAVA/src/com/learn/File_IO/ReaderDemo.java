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

import java.io.FileReader;
 import java.io.*;
public class ReaderDemo {

    public static void main(String[] args) throws Exception{
       FileReader fileReader=null;
        try {

             fileReader=new FileReader("d:\\test.txt");
            char[] chars=new char[1024];
            if((fileReader.read(chars))!=-1){
                


            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

}
