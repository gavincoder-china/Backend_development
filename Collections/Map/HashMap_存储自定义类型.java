package Map;

import java.util.HashMap;

public class HashMap_存储自定义类型 {
    /*
     * hashmap存储自定义类型的键值对
     * Map 集合必须保证 key 是唯一的
     *     作为 key 的元素,必须重写 hashcode 与 equals 方法
     * */

    public static void main(String[] args) {

        show01();
        show02();

    }

    /*
     * key: string 类型,string 已重写 hashcode 与 equals 方法
     * value:Person 类型,可以重复(同名同年龄的人)
     *
     * */
    private static void show01() {

        HashMap<String, Person> map = new HashMap<>();
        map.put("北京", new Person("张三", 18));
        map.put("上海", new Person("李四", 19));
        map.put("杭州", new Person("王五", 20));
        map.put("杭州", new Person("赵六", 20));

        //
        for (String p : map.keySet()) {

            System.out.println(map.get(p));


        }

    }

    /*
     * (同名同年龄的人)视为同一个人
     * key:Person 类型,不可重复,需要重写hashcode 与 equals 方法
     * value: string 类型
     *
     * */
    private static void show02() {

        HashMap<Person, String> map = new HashMap<>();
        map.put( new Person("张三", 18),"北京");
        map.put( new Person("李四", 19),"上海");
        map.put( new Person("王五", 20),"杭州");
        map.put( new Person("王五", 20),"上海");

        //遍历下
        for (Person p : map.keySet()) {

            System.out.println(map.get(p));


        }

    }


}
