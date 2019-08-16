package main.AOP;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-08-16 13:56
 * @description:
 ************************************************************/
public class CalculateImplProxy implements Calculate {

    @Override
    public int add(int i, int j) {
        int result =i+j;
        return result;
    }

    @Override
    public int sub(int i, int j) {
        int result =i-j;

        return result;
    }

    @Override
    public int mul(int i, int j) {
        int result =i*j;

        return result;
    }


    @Override
    public int div(int i, int j) {
        int result =i/j;

        return result;
    }
}
