import Utils.JedisPoolUtil;
import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * **********************************************************
 *
 * @Project: 通过jedis连接池来使用redis
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-08-05 19:18
 * @description:
 ************************************************************/
public class test02 {
    @Test
    public void redisDemo() {
        //通过工具类来获取jedis对象
        Jedis jedis = JedisPoolUtil.getJedis();

        //使用
        jedis.set("test", "true");

        //
        String test = jedis.get("test");
        System.out.println(test);
        //归还
        jedis.close();
    }

}
