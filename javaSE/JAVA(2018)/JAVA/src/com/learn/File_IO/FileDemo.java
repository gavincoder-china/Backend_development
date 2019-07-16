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

import java.io.File;
import java.io.IOException;

public class FileDemo {

    public static void main(String[] args)  throws IOException {
        File file=new File("e:\\filedemo");
        System.out.println(file.createNewFile());
        System.out.println(file.getName());
        System.out.println(file.canWrite());




    }
}
