package main.AOP;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-08-16 14:29
 * @description:
 ************************************************************/
public class testProxy {
    public static void main(String[] args) {

        Calculate calculate=new CalculateImplProxy();
        Calculate proxy = new CProxy(calculate).getProxy();
        int add = proxy.add(1, 2);
        System.out.println(add);

    }
}
