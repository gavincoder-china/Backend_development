package main.SpringAOP;

import org.springframework.stereotype.Component;


public interface Calculate {
    int add(int i, int j);
    int sub(int i, int j);
    int mul(int i, int j);
    int div(int i, int j);
    double divv(double i,double j);
}
