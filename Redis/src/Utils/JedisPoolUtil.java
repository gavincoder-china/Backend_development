package Utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.util.Properties;

/**
 * **********************************************************
 *
 * @Project: Jedis工具类
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-08-05 19:05
 * @description:  加载配置文件,配置的是连接池的参数,提供获取连接的方法
 ************************************************************/
public class JedisPoolUtil {
    private static JedisPool jedisPool;
    //配置文件jedis.properties
    //当类加载的时候,读取配置文件

    static {
        Properties props = new Properties();
        try {
            props.load(JedisPoolUtil.class.getClassLoader().getResourceAsStream("jedis.properties"));

            //获取数据,加载到jedisPoolConfig下
            JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
            jedisPoolConfig.setMaxTotal(Integer.parseInt(props.getProperty("maxTotal")));
            jedisPoolConfig.setMaxIdle(Integer.parseInt(props.getProperty("maxIdle")));

            //初始化 jedisPool
            jedisPool=  new JedisPool(jedisPoolConfig, props.getProperty("host"), Integer.parseInt(props.getProperty("port")));
        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }
    //获取连接的方法
    public static Jedis getJedis(){

        return jedisPool.getResource();
    }


}
