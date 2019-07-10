package Map;

import java.util.HashMap;
import java.util.Map;

public class EntrySetFunc {

    /*entrySet 方法来遍历 map
     *
     * 1.通过 entrySet 来获取 key,value 的 entry 对象 的 set 集合
     * 2.set集合可以使用 set 集合的遍历方法
     * 3.通过遍历 entry 的 set 集合来获取存在 set 中的 entry 对象,每一个 entry 对象都有k,v
     * */

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();

        map.put("java", 25);
        map.put("python", 28);
        map.put("js", 23);

       for(Map.Entry<String, Integer> e:map.entrySet()){

           System.out.println(e);

       }

        for(Map.Entry<String, Integer> e:map.entrySet()){


            String key = e.getKey();
            Integer value = e.getValue();
            System.out.println(key+":"+value);

        }



    }


}
