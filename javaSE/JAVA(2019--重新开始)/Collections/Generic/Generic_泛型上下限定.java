package Generic;

import java.util.ArrayList;
import java.util.Collection;

public class Generic_泛型上下限定 {

    /*
     * ? extends E  下限限定,只能使用 E的本身或者其子类
     * ? super E 上限限定 ,只能使用 E 的本身或者其父类
     *
     *
     * */
    public static void main(String[] args) {

        ArrayList<String> list01 = new ArrayList<>();
        ArrayList<Object> list02 = new ArrayList<>();
        ArrayList<Integer> list03 = new ArrayList<>();
        ArrayList<Number> list04 = new ArrayList<>();

        //Number 是 Integer 的父类

        //  Generic_泛型上下限定.test01(list01); 报错
        //  Generic_泛型上下限定.test01(list02); 报错
        Generic_泛型上下限定.test01(list03);
        Generic_泛型上下限定.test01(list04);


        //  Generic_泛型上下限定.test02(list01);  报错
        Generic_泛型上下限定.test02(list02);
        //   Generic_泛型上下限定.test02(list03);  报错
        Generic_泛型上下限定.test02(list04);

    }

    //下限
    private static void test01(Collection<? extends Number> coll) {


    }

     //上限

    private static void test02(Collection<? super Number> coll) {


    }
}
