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

package com.learn.Collection;

import java.util.ArrayList;
import java.util.List;

/***
 * @Description： 自己实现一个ArrayList

 * @Param:
 * @Return:
 * @Auther: Gavincoder
 * @Date: 2018/9/19
 */
public class SetArrayList {

    private Object[] elementData;
    private int size;
     public int size(){
         return size;
     }
    /*
     * 构造器*/
    public SetArrayList() throws Exception {
        this(10);
    }
    public boolean isEmpty(){
        if(size==0){
            return false;
        }
        else return true;
    }
    public Object get(int index){
        if(index<0||index>=size){

            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
         return  elementData[index];

    }

    public  void remove(int index){

        int numMoved=size-index-1;
        if(numMoved>0){
            System.arraycopy(elementData,index+1,elementData,index,numMoved);
                         elementData[--size]=null;
        }
        
    }


    public SetArrayList(int initialCapacity) throws Exception {
        if (initialCapacity < 0) {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
            }

        }
        elementData = new Object[initialCapacity];

    }

    public void add(Object object) {
             /*
           /数组扩容 &数组拷贝
                      */
        if (size == elementData.length) {
            Object[] newArray = new Object[1 + size * 2];
            //数组拷贝
            System.arraycopy(elementData, 0, newArray, 0, elementData.length);
            elementData = newArray;
        }

        elementData[size++] = object;


    }


    public static void main(String[] args) {
        List list = new ArrayList(3);
        list.add(46545);
        list.add(46545);
        list.add(46545);
        list.add(46545);
        list.add(46545);
        list.add(46545);
        list.add(46545);
        list.add(46545);
        list.add(46545);
        list.add(46545);
        list.add(46545);
        list.add(46545);
        list.add(46545);
        list.add(46545);
        list.add(46545);
        list.add(46545);
        list.add(46545);
        list.add(46545);
        list.add(46545);
        System.out.println(list.size());


    }


}
