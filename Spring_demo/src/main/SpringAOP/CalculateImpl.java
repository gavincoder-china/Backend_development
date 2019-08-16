package main.SpringAOP;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-08-16 13:56
 * @description:将该类放进spring容器
 ************************************************************/

//@Component("cal")
@Component
public class CalculateImpl implements Calculate {

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

    @Override
    public double divv(double i, double j) {
        double result = i / j;

        return result;
    }

}
