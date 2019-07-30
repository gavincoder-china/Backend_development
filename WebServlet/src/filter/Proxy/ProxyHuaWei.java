package filter.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-07-30 10:03
 * @description:
 ************************************************************/
public class ProxyHuaWei {

    public static void main(String[] args) {
        //1.创建真实对象

        HuaWei huaWei = new HuaWei();


        //2.动态代理增强lenovo对象
        /*
            三个参数：
                1. 类加载器：真实对象.getClass().getClassLoader()
                2. 接口数组：真实对象.getClass().getInterfaces()
                3. 处理器：new InvocationHandler()
         */
        SaleComputer proxy_huawei = (SaleComputer) Proxy.newProxyInstance(huaWei.getClass().getClassLoader(), huaWei.getClass().getInterfaces(), new InvocationHandler() {
            /*
                  代理逻辑编写的方法：代理对象调用的所有方法都会触发该方法执行(多次)
                      参数：
                          1. proxy:代理对象
                          2. method：代理对象调用的方法，被封装为的对象
                          3. args:代理对象调用的方法时，传递的实际参数
               */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                //增强参数方法
                if ("sale".equals(method.getName())) {
                    double money = (double) args[0];
                    money = 0.8 * money;

                    //调用真实对象
                    Object obj = method.invoke(huaWei, money);

                    //增强返回值
                    return obj + "送键盘鼠标";
                } else {
                    //普通方法
                    Object obj = method.invoke(huaWei, args);
                    return obj;
                }


            }


        });


        //3.调用方法

        String sale = proxy_huawei.sale(8000);
        System.out.println(sale);
        proxy_huawei.show();

    }
}
