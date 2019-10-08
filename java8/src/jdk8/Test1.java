package jdk8;


import java.util.Arrays;
import java.util.List;


public class Test1 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

//        for(int i = 0; i < list.size(); ++i) {
//            System.out.println(list.get(i));
//        }
//
//        System.out.println("----------");
//
//        for(Integer i : list) {
//            System.out.println(i);
//        }
//
//        System.out.println("----------");

        // method reference


        list.forEach(System.out::println);


    }



}
