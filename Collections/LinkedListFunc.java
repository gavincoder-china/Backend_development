import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListFunc {
    /*
     * 特点
     *    底层是链表:查询慢,增删快
     *    包含了大量操作首位元素的方法

     * */

    public static void main(String[] args) {
        show01();
        show02();
        show03();


    }

    private static void show01() {
        //创建 linkedList 集合对象
        LinkedList<String> linked = new LinkedList<>();
        linked.add("a");
        linked.add("b");
        linked.add("c");
        linked.add("d");
       //增加元素

        //(1)addfirst
        linked.addFirst("开头");
        //push 等效于 addfirst
        linked.push("push 开头");

        //(2)addlast
        linked.addLast("结尾");


        System.out.println(linked);

    }

    private static void show02() {
        LinkedList<String> linked = new LinkedList<>();
        linked.add("a");
        linked.add("b");
        linked.add("c");
        linked.add("d");
//获取元素
        String first = linked.getFirst();
        String last = linked.getLast();


        System.out.println(linked);
        System.out.println(first + last);

        //tip
        //三种遍历方式
        //<1>普通 for 循环
        for (int i = 0; i < linked.size(); i++) {
            System.out.println(linked.get(i));
        }

        //<2>iterator遍历t
        Iterator<String> it = linked.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        //<3>for each
        for (String s : linked) {
            System.out.println(s);

        }

    }

    private static void show03() {

        LinkedList<String> linked = new LinkedList<>();
        linked.add("a");
        linked.add("b");
        linked.add("c");
        linked.add("d");

        String s = linked.removeFirst();
        String s1 = linked.removeLast();

        //弹出第一个元素 相当于 removefirst
        String pop = linked.pop();
        System.out.println(linked);

        System.out.println(s + s1 + pop);


    }
}
