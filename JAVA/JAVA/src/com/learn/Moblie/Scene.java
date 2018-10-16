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

package com.learn.Moblie;


import java.util.HashMap;
import java.util.Map;

/***
* @Description：这个是消费的场景，

* @Param: 
* @Return: 
* @Auther: Gavincoder
* @Date: 2018/9/16
*/
public class Scene {
   //Scene scene=new Scene();
    public Map SceneMap() {

        Map<Object,Object> map=new HashMap<>();
        map.put(1,21);
        map.put(3,23);
        map.put(4,24);
          return map;
    }
}
