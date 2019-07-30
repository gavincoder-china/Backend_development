package filter.Proxy;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-07-30 10:01
 * @description:
 ************************************************************/
public class HuaWei implements SaleComputer {
    @Override
    public String sale(double money) {
        System.out.println("花了"+money+"买了一台电脑...");
        return "华为电脑";
    }

    @Override
    public void show() {
        System.out.println("展示电脑....");
    }
}
