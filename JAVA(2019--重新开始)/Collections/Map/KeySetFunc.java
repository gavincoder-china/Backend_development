package Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class KeySetFunc {

    /*keyset 方法来遍历 map
    *
    * 1.通过 keyset 来获取 key 的 sety 集合
    * 2.set集合可以使用 set 集合的遍历方法
    * 3.通过遍历 key 的 set 集合来 get 其中的 value
    * */

    public static void main(String[] args) {

        Map<String, Integer> map02 = new HashMap<>();

        map02.put("java", 25);
        map02.put("python", 28);
        map02.put("js", 23);


       // Set<String> set = map02.keySet();

        for (String s : map02.keySet()) {

            System.out.println(s+":"+map02.get(s));

        }


    }
}
