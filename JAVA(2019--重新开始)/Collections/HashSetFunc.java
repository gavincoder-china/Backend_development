import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetFunc {

    /*
    * set 接口
    * 特点
    *    1.不允许存储重复的元素
    *    2.没有索引,不带有索引的方法
    *    3.不能使用普通 for 循环遍历
    *
    * */


    /*hashSet
    *   特点:
    *       1.是一个无序的结构,存储顺序与取出顺序不一致
    *       2.底层是 hashmap哈希表结构,查询速度非常快
    *
    * */
    public static void main(String[] args) {

        Set<Object> set = new HashSet<>();
set.add(1);
set.add(6);
set.add(3);
set.add(4);
set.add(5);
set.add(5);
        Iterator<Object> it = set.iterator();

        while (it.hasNext()){
            System.out.println(it.next());
        }


    }

}
