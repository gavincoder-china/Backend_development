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

public class 冒泡排序 {

    public static void main(String[] args) {

        String[] array = {"bbb", "aaa", "eee", "ddd", "ccc"};

        for (int i = 0; i < array.length; i++) {


            for (int j = i + 1; j < array.length; j++) {

                if (((array[j]).compareTo((array[i])) >0)) {      //字符串的比较是真的坑
                    String temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }


    }


}
