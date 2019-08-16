package main.SpringAOP;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-08-16 15:23
 * @description:
 ************************************************************/
public class TestAOP {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
       // Calculate cal = (Calculate) ctx.getBean("cal");
        //这边用的是接口作为class类
        Calculate cal =  ctx.getBean(Calculate.class);

        cal.add(1, 1);
        cal.sub(1, 1);
        cal.mul(1, 1);
        cal.div(1, 1);
        cal.divv(1,0);


    }
}
