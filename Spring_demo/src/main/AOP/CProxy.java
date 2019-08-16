package main.AOP;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * **********************************************************
 *
 * @Project: CalculateImplProxy的代理类
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-08-16 14:13
 * @description:
 ************************************************************/
public class CProxy {
    //需要代理的接口
    private Calculate proxy;


    //构造方法
    public CProxy(Calculate proxy) {
        this.proxy = proxy;
    }

    //代理要执行的方法
    public Calculate getProxy() {

        Calculate calculate = null;

        ClassLoader classLoader = proxy.getClass().getClassLoader();

        //需要代理的接口数组,可多个
        Class[] interfaces = {Calculate.class};

        //代理具体要执行的操作

        InvocationHandler invocationHandler = new InvocationHandler() {

            /**
             * @description
             * proxy(obj):代理对象
             * method:正在被调用的方法
             * args:调用方法时传入的参数
             * @author Gavin
             * @date 2019-08-16 14:26

             * @return java.lang.Object
             * @throws
             * @since
             */

            @Override
            public Object invoke(Object object, Method method, Object[] args) throws Throwable {
                System.out.println("方法开始");
                //开始
                Object invoke = method.invoke(proxy, args);

                System.out.println("方法结束");
                return null;
            }
        };

        calculate = (Calculate) Proxy.newProxyInstance(
                classLoader,
                interfaces,
                invocationHandler);


        return null;

    }


}
