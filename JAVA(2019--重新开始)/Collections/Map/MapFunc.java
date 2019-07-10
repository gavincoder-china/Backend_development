package Map;

import java.util.HashMap;
import java.util.Map;

public class MapFunc {

/*hashmap
  特点:
     1.底层是 哈希表,查询速度快
      1.8 之前是数组+单项链表
      1.8之后是数组+红黑树

     2.无序的集合

  linkedHashMap
    特点:
        1.底层是 哈希表+链表 (保证迭代顺序)
        2.有序集合,存储元素与取出顺序一致
*
*
* */

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();


        //(1)put 存储键值对的时候,如果key 不重复,返回空null
        //如果key 重复,则将原来的 value 值覆盖,返回原来的 value
        String v1 = map.put("李晨", "范冰冰 1");
        String v2 = map.put("李晨", "范冰冰 2");

        System.out.println(v1);
        System.out.println(v2);
        System.out.println(map);


        //(2)remove  返回被删除元素的值
        //如果 key 存在 ,返回被删除的值
        //如果key不存在 ,返回 null
        Map<String, Integer> map02 = new HashMap<>();
        map02.put("java", 25);
        map02.put("python", 28);
        map02.put("js", 23);
        System.out.println(map02);
        Integer r1 = map02.remove("java");
        System.out.println(r1);


        //(3)get
        System.out.println(map02.get("js"));
        System.out.println(map02.get("java"));
        //containsKey
        System.out.println(map02.containsKey("js"));
        System.out.println(map02.containsKey("java"));



    }


}
