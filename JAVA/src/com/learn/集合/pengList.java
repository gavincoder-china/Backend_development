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

package com.learn.集合;

import javax.print.DocFlavor;
import java.util.*;

public class pengList {

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("欧欧 Q仔");
        list.add("亚亚 Q妹");
        list.add("菲菲 Q妹");
        list.add("美美 Q妹");
    //    list.remove(2);
      //  list.remove(2);
     //   System.out.println(list.contains("美美 Q妹"));
     //   System.out.println(list);
        Map<String, String> map = new HashMap<String, String>();
        map.put("欧欧", " Q仔");
        map.put("亚亚 ", "Q妹");
        map.put("菲菲 ", "Q妹");
        map.put("美美", "Q妹");

        /*Iterator遍历*/
        Iterator<String> iterator=map.keySet().iterator();
        while (iterator.hasNext()){
            String key=iterator.next();
            System.out.println(key+"  "+map.get(key));
        }

        Map<Integer, String> mapPen = new HashMap<Integer, String>();

        mapPen.put(1,"欧欧 Q仔");
        mapPen.put(2,"亚亚 Q妹");
        mapPen.put(3,"菲菲 Q妹");
        mapPen.put(4,"美美 Q妹");
          /*for each遍历*/
        for(Integer key:mapPen.keySet()){
            System.out.println(key+"  "+mapPen.get(key));


        }






    }
}
