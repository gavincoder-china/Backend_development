package main;

import java.util.Arrays;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-08-19 13:56
 * @description:
 ************************************************************/
public class yyyyy {

    //张洪志面试题
    public enum P{
        ONE(1){
            public String toString(){
                return "low";
            }
        },
        TWO(2),
        THREE(3) { public String toString() {return "Normal";}},
        FOUR(4),
        FIVE(5){ public String toString() {return "HIGH";}};
        private int pvalue;
        P(int pvalue){
            this.pvalue = pvalue;
        }
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(P.values())
                          );
    }
}
