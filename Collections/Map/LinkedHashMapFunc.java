package Map;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class LinkedHashMapFunc {

    /*
     * 特点:
     *    1:继承 hashmap
     *    2.有序的集合
     *   底层是哈希表+链表
     *
     * */

    public static void main(String[] args) {

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(4, 4);
        map.put(5, 5);
        map.put(3, 3);

        System.out.println(map); //{1=1, 2=2, 3=3, 4=4, 5=5}


        LinkedHashMap<Integer, Integer> linked = new LinkedHashMap<>();
        linked.put(1, 1);
        linked.put(2, 2);
        linked.put(4, 4);
        linked.put(5, 5);
        linked.put(3, 3);
        System.out.println(linked); //顺序不变{1=1, 2=2, 4=4, 5=5, 3=3}

    }
}
