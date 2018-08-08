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

package 面向对象;

import java.util.Arrays;

/**
 * 编写一个测试类，里面有两个方法
 * 第一个方法返回值为int[]数组，传入参数为5个int类型数据，并把这个5个int类型数据放入该数组。
 * 第二个方法返回值为空，传入一个int类型数组，并使用冒泡排序对这个数组进行排序（从大到小）
 * （测试中使用第一个方法获取一个int数组，然后使用第二个方法对该数组进行排序）
 */
public class TestArray {

    public int[] array1(int a0, int a1, int a2, int a3, int a4) {
        int[] a = new int[5];
        a[0] = a0;
        a[1] = a1;
        a[2] = a2;
        a[3] = a3;
        a[4] = a4;
        return a;
    }

    public void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] < a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }

        }
        System.out.println(Arrays.toString(a));

    }

    public static void main(String[] args) {
        TestArray testArray = new TestArray();
        int[] a = testArray.array1(5, 4, 8, 2, 4);
        testArray.sort(a);
    }
}


