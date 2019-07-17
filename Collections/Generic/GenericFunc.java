package Generic;

public class GenericFunc {

    /*泛型方法
    泛型定义在方法的修饰符与返回值中间
    格式:
        修饰符<泛型> 返回值类型 方法名 (参数列表(使用泛型))

        */


    private static <E> void func01(E e) {

        System.out.println(e);
    }

    public static void main(String[] args) {

        int a = 100;
        //泛型类型在方法调用时确定
        //静态方法 使用  类名.方法名  调用
        GenericFunc.func01(a);
        GenericFunc.func01("string");

    }
}
