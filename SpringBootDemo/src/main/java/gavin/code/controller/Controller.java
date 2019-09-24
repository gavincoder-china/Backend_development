package gavin.code.controller;

import com.alibaba.fastjson.JSONObject;
import gavin.code.dto.User;
import gavin.code.service.UsersService;
import gavin.code.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-08-28 19:17
 * @description:
 ************************************************************/

@RestController
@RequestMapping(value = "/v1")
public class Controller {


    @Autowired
    private UsersService usersService;

    @Autowired
    private RedisUtils redisUtils;

    @GetMapping(value = "/show")
    public List<User> select() {
        return usersService.select();
    }

    @GetMapping(value = "/redis")
    public String testRedis(@RequestParam String key, @RequestParam String value) {

        redisUtils.set(key, value);
        //测试序列化
        redisUtils.set("china", "我爱中国");


        return (String) redisUtils.get(key) + redisUtils.get("china");

    }

    @GetMapping(value = "/redisNameSpace")
    public String testRedis2() {

        String nameSpace = "KH68:";
        redisUtils.set(nameSpace + "gavin", "nice");
        redisUtils.set(nameSpace + "betty", "beactiful");
        redisUtils.set(nameSpace + "myra", "perfect");

        return (String) redisUtils.get(nameSpace + "gavin");


    }


    @GetMapping(value = "/fastjson")
    public void testRedis3() {

        //创建对象并赋值(这边按照你自己的方式去实现)
        User user = new User();
        user.setUsername("gavin");
        user.setUid(11);
        user.setGender(1);
        user.setPassword("password");

        //将对字符串象转换成json字符串
        String s = JSONObject.toJSONString(user);

        //将json字符串转换为对象
        User user1 = JSONObject.parseObject(s, User.class);

        //打印测试对象
        System.out.println(user1);


    }
}
