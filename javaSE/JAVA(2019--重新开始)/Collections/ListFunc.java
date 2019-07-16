import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ListFunc {
    /*特点
     *  1.有序的集合,存储元素与取出元素的顺序是一致的
     *
     *  2.有索引,包含一些带索引的方法
     *  3.允许存储重复元素
     *
     * */

    public static void main(String[] args) {
        //注意,操作索引的时候,防止越界
        //创建一个 list 对象,使用多态
        List<String> list = new ArrayList<>();
        //添加元素
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("a");
        //打印集合  iterator 操作下

       /* Iterator<String> it = list.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }*/

        //(1)在给定索引处添加新元素
        list.add(2, "添加元素 1");
        //(2)remove 移除指定索引的元素,并返回被移除的元素
        String remove01 = list.remove(3);
        //(3)set 用指定元素替换指定索引处的元素,并返回被替代的元素
        list.set(4, "我是最后一个");
        //(4)get 获取指定索引的元素,常用在遍历中


        // 所以这边可以引申出三种 list 的遍历方式

                    //<1>普通 for 循环
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println(list.get(i));
                    }
                    //<2>iterator遍历
                    Iterator<String> it = list.iterator();
                    while (it.hasNext()) {
                        System.out.println(it.next());
                    }
                    //<3>for each
                    for (String s : list) {
                        System.out.println(s);

                    }



    }
}
