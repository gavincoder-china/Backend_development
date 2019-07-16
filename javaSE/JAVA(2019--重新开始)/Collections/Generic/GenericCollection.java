package Generic;

import java.util.ArrayList;
import java.util.Iterator;

public class GenericCollection {
    //泛型
    public static void main(String[] args) {
        show02();
    }

    /*创建集合对象,不使用泛型
     * 好处:
     *     默认的类型就是 object,可以存储任意类型的数据
     * 弊端:
     *     集合不安全,会引发异常
     * */
    private static void show01() {
        ArrayList list = new ArrayList();
        list.add("abc");
        list.add(123);

        Iterator it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
            //如果想要使用 String 的 length 方法获取长度,则不行
            //则需要向下转型,将 object 变成 string
            //但是 integer 无法转换到 string,会报错


        }


    }

    /*使用泛型
     *好处:
     *    1.避免了类型转化的麻烦
     *    2.将运行期异常提升到编译期,如果存入的不是规定的数据类型,编译器会爆红
     * 弊端:
     *    存储的数据类型被限制
     * */
    private static void show02() {
        ArrayList<String> list = new ArrayList<>();
        list.add("abc");
        list.add("123");
        list.add("666");
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }


    }
}
