package Map;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class CountTimes {
    public static void main(String[] args) {

        /*
         *
         * 1.使用 scanner 获取用户输入的数据
         * 2.创建map 集合,key 是字符串中的字符,value 是字符的个数
         * 3.遍历字符串,获取每一个字符
         * 4.使用获取到的字符,去 map 集合中判断 key 是否存在
         *    key 存在
         *            通过字符(key),获取 value 的个数
         *               value++
         *             put (key,value)把新的 value 存进去
         *
         *    key 不存在
         *      put(key,1)
         *  5.遍历 map 集合,输出结果
         * */

//1.scanner
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串:");
        String str = sc.next();
        //2.创建 map 集合
        HashMap<Character, Integer> map = new HashMap<>();

//3.遍历字符串
        for (char c : str.toCharArray()) {

//4.
            if (map.containsKey(c)) {
                //存在
                Integer value = map.get(c);
                value++;
                map.put(c, value);

            } else {
                //key 不存在
                map.put(c, 1);
            }
        }
        //5.
        Set<Character> keySet = map.keySet();
        for (Character c : keySet) {
            System.out.println(c + ":" + map.get(c));

        }
    }
}
