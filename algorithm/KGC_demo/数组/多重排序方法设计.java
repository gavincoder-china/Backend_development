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

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class 多重排序方法设计 {
    /*主函数*/
    public static void main(String[] args) {

        System.out.println("**********欢迎来到排序算法选择程序**********");
        System.out.print("1、直接插入排序\t");
        System.out.println("2、希尔排序\t");
        System.out.println();
        System.out.print("3、简单选择排序\t");
        System.out.println("4、堆排序\t");
        System.out.println();
        System.out.print("5、冒泡排序\t\t");
        System.out.println("6、快速排序\t");
        System.out.println();
        System.out.print("7、归并排序\t\t");
        System.out.println("8、基数排序\t");
        System.out.println();
        System.out.println("****************************************");
        System.out.println("您需要哪一种排序方法？请输入对应数字：");
        System.out.println("现在只完成了1、2、3、5");

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i == 0; ) {


            int choiceSort = scanner.nextInt();
            if (choiceSort > 0 && choiceSort < 9) {
                switch (choiceSort) {

                    case 1:
                        //直接插入排序
                        多重排序方法设计.Insertion();   //ok
                        break;

                    case 2:
                        //希尔排序
                           多重排序方法设计.Shell();        //ok
                           break;

                    case 3:
                        //简单选择排序
                        多重排序方法设计.Selection();           //ok
                        break;

                    case 4:
                        //堆排序
                           多重排序方法设计.Heap();
                           break;
                    case 5:
                        //冒泡排序
                            多重排序方法设计.Bubble();          //ok
                            break;
                    case 6:
                        //快速排序
                            多重排序方法设计.Quick();
                            break;
                    case 7:
                        //归并排序
                             多重排序方法设计.Merge();
                             break;
                    default:
                        //基数排序
                               多重排序方法设计.Radix();
                               break;
                }         //switch
                i = 1;
                //结束循环输入
            }            //if
            else {
                System.out.println("请输入1-8之间的整数：");
            }

        }   //for
    }    //main


    /*生成随机数组*/
    public static int[] randomArray(int length) {
        int[] array = new int[length];

        for (int i = 0; i < length; i++) {
            int arrayNum=new Random().nextInt();
            array[i] =arrayNum ;

        }

        return array;

    }   //生成随机数组

    /*打印数组字符串*/
    public static void printArray(int[] array, boolean flag) {
        //flag用来判断是否是排序前后的数组，true为排序前，flase为排序后
        if (array.length > 12) {
            if (flag == true) {

                System.out.print("这是排序前的数组：");
                for (int i = 0; i < 6; i++) {
                    System.out.print(array[i] + "\t" );
                }
                System.out.print("......");
                for (int i = array.length - 6; i < array.length; i++) {
                    System.out.print(array[i] + "\t");

                }
                System.out.println();
            } else {

                System.out.print("这是排序后的数组：");
                for (int i = 0; i < 6; i++) {
                    System.out.print(array[i] + "\t" );
                }
                System.out.print("......");
                for (int i = array.length - 6; i < array.length; i++) {
                    System.out.print(array[i] + "\t");

                }
                System.out.println();
            }
        } else {

            if (flag == true) {
                System.out.println("这是排序前的数组：" + Arrays.toString(array));

            } else {
                System.out.println("这是排序后的数组：" + Arrays.toString(array));

            }


        }

    }   //打印数组字符串

    /**
     * 交换数组中两个数的位置
     */
    public static void exchange(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /*设计数组长度*/
    public static int lengthArray() {
        System.out.println("请输入您想要设计的数组的长度");
        Scanner scan = new Scanner(System.in);
        int lengthArray = scan.nextInt();
        System.out.println("您想要设计的数组长为" + lengthArray);
        return lengthArray;


    }

    /*直接插入排序*/
    public static void Insertion() {
        int lengthArray = 多重排序方法设计.lengthArray();
        int[] array = 多重排序方法设计.randomArray(lengthArray);
        多重排序方法设计.printArray(array, true);
        long startTime = System.currentTimeMillis();
        for (int i = 1; i < array.length ; i++) {
            for (int j = 0; j <= i; j++) {
                if (array[i] < array[j]) {

                    //插入，并将原数组值依次后移
                    int temp = array[i];
                    //暂存数值
                    for (int k = i; k > j; k--) {
                        array[k] = array[k - 1];
                    }
                    array[j] = temp;

                }

            }
        }


        long endTime = System.currentTimeMillis();
        多重排序方法设计.printArray(array, false);
        System.out.println("用时：" + (endTime - startTime) + "毫秒");


    }

    /*希尔排序*/
    public static void Shell() {
        int lengthArray = 多重排序方法设计.lengthArray();
        int[] array = 多重排序方法设计.randomArray(lengthArray);
        多重排序方法设计.printArray(array, true);
        long startTime = System.currentTimeMillis();
       // int length =array.length;
        int h = 1;
        //h为分区后每块有多少个元素
        int block=3;
        //分块大小（大于1的值）
        while (h < lengthArray / block) {
            h = block* h + 1;
            //通过循环算出h的取值，当分区大小为3时，h序列为1, 4, 13, 40, ...
        }
        while (h >= 1) {
            int n, i ,j, k;
            //分割后，产生n个子序列
            for (n = 0; n < h; n++) {
                //分别对每个子序列进行直接插入排序
                for (i = n + h; i < lengthArray; i += h) {
                    for (j = i - h; j >= 0 && array[i] < array[j]; j -= h) {

                    }
                    int tmp = array[i];
                    for (k = i; k > j + h; k -= h) {
                        array[k] = array[k-h];
                    }
                    array[j+h] = tmp;
                }
            }
            //直接插入排序完后，减少每块区里的元素。也就是说增大块区的数量，直到最后h=1(每块区里只有一个元素时，排序完成)
            h = h / block;
        }

        

        long endTime = System.currentTimeMillis();
        多重排序方法设计.printArray(array, false);
        System.out.println("用时：" + (endTime - startTime) + "毫秒");
    }


    /*简单选择排序*/
    public static void Selection() {
        int lengthArray = 多重排序方法设计.lengthArray();
        int[] array = 多重排序方法设计.randomArray(lengthArray);
        多重排序方法设计.printArray(array, true);
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < array.length; i++) {
            int temp=i;
            //用来保存每一趟最小值数组的下标，开始前假设第一个数字为这趟的最小值
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    temp=j;
                }
                多重排序方法设计.exchange(array,temp,i);
                //将这趟的第一个数字和这趟的最小值交换位置
            }
        }
        

        long endTime = System.currentTimeMillis();
        多重排序方法设计.printArray(array, false);
        System.out.println("用时：" + (endTime - startTime) + "毫秒");
    }


    /*堆排序*/
    public static void Heap() {
        int lengthArray = 多重排序方法设计.lengthArray();
        int[] array = 多重排序方法设计.randomArray(lengthArray);
        多重排序方法设计.printArray(array, true);
        long startTime = System.currentTimeMillis();






        long endTime = System.currentTimeMillis();
        多重排序方法设计.printArray(array, false);
        System.out.println("用时：" + (endTime - startTime) + "毫秒");
    }


    /*冒泡排序*/
    public static void Bubble() {
        int lengthArray = 多重排序方法设计.lengthArray();
        int[] array = 多重排序方法设计.randomArray(lengthArray);
        多重排序方法设计.printArray(array, true);
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    多重排序方法设计.exchange(array,i,j);
                }
            }
        }

        long endTime = System.currentTimeMillis();
        多重排序方法设计.printArray(array, false);
        System.out.println("用时：" + (endTime - startTime) + "毫秒");


    }


    /*快速排序*/
    public static void Quick() {
        int lengthArray = 多重排序方法设计.lengthArray();
        int[] array = 多重排序方法设计.randomArray(lengthArray);
        多重排序方法设计.printArray(array, true);
        long startTime = System.currentTimeMillis();







        long endTime = System.currentTimeMillis();
        多重排序方法设计.printArray(array, false);
        System.out.println("用时：" + (endTime - startTime) + "毫秒");
    }


    /*归并排序*/
    public static void Merge() {
        int lengthArray = 多重排序方法设计.lengthArray();
        int[] array = 多重排序方法设计.randomArray(lengthArray);
        多重排序方法设计.printArray(array, true);
        long startTime = System.currentTimeMillis();







        long endTime = System.currentTimeMillis();
        多重排序方法设计.printArray(array, false);
        System.out.println("用时：" + (endTime - startTime) + "毫秒");

    }


    /*基数排序*/
    public static void Radix() {
        int lengthArray = 多重排序方法设计.lengthArray();
        int[] array = 多重排序方法设计.randomArray(lengthArray);
        多重排序方法设计.printArray(array, true);
        long startTime = System.currentTimeMillis();






        long endTime = System.currentTimeMillis();
        多重排序方法设计.printArray(array, false);
        System.out.println("用时：" + (endTime - startTime) + "毫秒");
    }


}   //本class



