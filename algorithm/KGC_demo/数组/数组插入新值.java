import java.util.Arrays;

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
//3.一个数组为{a,b,c,d,g,h},要求在g前面插入一个字母e并输出
public class 数组插入新值 {
    public static void main(String[] args) {
      String[] array={"a","b","c","d","g","h",""};
        int num=Arrays.binarySearch(array,"g");
        for (int i =(array.length-1) ; i >=num ; i--) {
                array[i]=array[i-1];
        }
        array[num]="e";
        for (int i = 0; i <array.length ; i++) {
            System.out.println(array[i]);
        }

    }
}
