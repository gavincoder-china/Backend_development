package Service.impl;

import DAO.FindDao;
import DAO.impl.FindDaoImpl;
import Entity.Province;
import Service.FindService;
import Utils.JedisPoolUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-08-06 11:11
 * @description:
 ************************************************************/
public class FindServiceImpl implements FindService {
FindDao dao=new FindDaoImpl();

    @Override
    public String find() {
        //这边就是判断redis内是否有值
        Jedis jedis = JedisPoolUtil.getJedis();
        String province = jedis.get("province");
        if(province==null||province==""){
            //证明没有数据需要从MySQL中读取

            List<Province> list = dao.find();

        //   需要将其转成json
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                province = objectMapper.writeValueAsString(list);
            }
            catch (JsonProcessingException e) {
                e.printStackTrace();
            }

            jedis.set("province",province);
            return province;
        }else {
         //如果redis缓存中存在该数据,则返回
            System.out.println("有缓存.....");
            return province;

        }









    }



}
