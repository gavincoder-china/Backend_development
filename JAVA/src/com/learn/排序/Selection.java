package com.learn.排序;

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
//选择排序
public class Selection {

    public static boolean less(Comparable v, Comparable w) {

        return v.compareTo(w) < 0;
    }


    public static void exch(Comparable[] a, int i, int j) {


        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i] + "");

        }
    }

    public static boolean isSorted(Comparable[] a) {

        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1]))
                return false;
            else {
                return true;
            }
        }
        return true;
    }


    public static void main(String[] args) {

        String[] a = {"22222", "11111", "00000", "33333", "99999"};
        sort(a);
        assert isSorted(a);
        show(a);




    }


    public static void sort(Comparable[] a) {
        //升序排列
        int N = a.length;
        for (int i = 0; i < N; i++) {
            //将a[i]跟后面最小的交换
               /*设置最小的索引*/
            int min = i;
            for (int j = i + 1; j < N; j++) {

                if (less(a[j], a[min])) {
                    min = j;
                }
                exch(a, i, min);

            }

        }

    }
}
