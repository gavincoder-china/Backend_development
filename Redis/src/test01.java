import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-08-05 16:07
 * @description:
 ************************************************************/
public class test01 {


    @Test
    public void redisDemo() {


        //1. 获取连接
        Jedis jedis = new Jedis();//如果使用空参构造，默认值 "localhost",6379端口
        //2. 操作

        // 1) 字符串类型 string
        //   set
        //   get

        //存储
        jedis.set("username", "zhangsan");
        //获取
        String username = jedis.get("username");
        System.out.println(username);

        //可以使用setex()方法存储可以指定过期时间的 key value
        jedis.setex("activecode", 20, "hehe");//将activecode：hehe键值对存入redis，并且20秒后自动删除该键值对


//        2)哈希类型 hash ：map格式
//                hset
//                hget
//                hgetAll

        // 存储hash
        jedis.hset("user", "name", "lisi");
        jedis.hset("user", "age", "23");
        jedis.hset("user", "gender", "female");
        jedis.hset("user", "phone", "15950519999");
        // 获取hash
        String name = jedis.hget("user", "name");
        System.out.println(name);


        // 获取hash的所有map中的数据
        Map<String, String> map = jedis.hgetAll("user");

        Set<Map.Entry<String, String>> entrySet = map.entrySet();

        System.out.println("*********");
        for (Map.Entry<String, String> entry : entrySet) {

            System.out.println(entry.getKey());
            System.out.println(entry.getValue());

        }




//
//        3)列表类型 list ：linkedlist格式。支持重复元素
//        lpush / rpush
//        lpop / rpop
//        lrange start end:
//        范围获取


        // list 存储
        jedis.lpush("mylist", "a", "b", "c");//从左边存
        jedis.rpush("mylist", "a", "b", "c");//从右边存

        // list 范围获取
        List<String> mylist = jedis.lrange("mylist", 0, -1);
        System.out.println(mylist);

        // list 弹出
        String element1 = jedis.lpop("mylist");//c
        System.out.println(element1);

        String element2 = jedis.rpop("mylist");//c
        System.out.println(element2);

        // list 范围获取
        List<String> mylist2 = jedis.lrange("mylist", 0, -1);
        System.out.println(mylist2);


//        4)集合类型 set  ：不允许重复元素
//                sadd
//        smembers:
//        获取所有元素


        // set 存储
        jedis.sadd("myset", "java", "php", "c++");


        System.out.println("________");
        jedis.smembers("myset");
        // set 获取
        Set<String> myset = jedis.smembers("myset");
        System.out.println(myset);

//
//        5)有序集合类型 sortedset：不允许重复元素，且元素有顺序
//                zadd
//        zrange


        // sortedset 存储
        jedis.zadd("mysortedset", 3, "亚瑟");
        jedis.zadd("mysortedset", 30, "后裔");
        jedis.zadd("mysortedset", 55, "孙悟空");



        // sortedset 获取
        Set<String> mysortedset = jedis.zrange("mysortedset", 0, -1);


        System.out.println(mysortedset);


        //3. 关闭连接
        jedis.close();


    }
}
