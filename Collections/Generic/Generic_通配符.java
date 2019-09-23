package Generic;

import java.util.ArrayList;

public class Generic_通配符 {
    /*
    * ?:代表任意的数据类型
    *
    * 使用:
    *    1:不能创建对象使用
    *    2:只能作为方法的参数使用
    *
    * 泛型没有继承概念,object 不包括 string
    * */

    public static void main(String[] args) {

        ArrayList<String> list01=new ArrayList<>();
        list01.add("java");
        list01.add("go");
        list01.add("python");
        Generic_通配符.printArr(list01);

        ArrayList<Integer> list02=new ArrayList<>();
        list02.add(111);
        list02.add(222);
        list02.add(333);
        Generic_通配符.printArr(list02);

//        ArrayList<?> list03=new ArrayList<?>();
//        这边不能用,因为?通配符只能调用,不能写入创建对象

    }
    //这边是不能用 object 的,因为泛型没有继承概念,string等子类 不属于object 对象
private static void printArr(ArrayList<?> list){

        for (Object o : list){
            System.out.println(o);
        }

}

}
