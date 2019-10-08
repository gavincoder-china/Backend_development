package jdk8.stream;


import java.util.stream.IntStream;

public class StreamTest2 {
    //自定义方法
    public void addd(int x) {
        System.out.println(x + "hh");
    }

    public static void main(String[] args) {

        //展示下::的用法

        IntStream.of(new int[]{5, 6, 7}).forEach(new StreamTest2()::addd);

        System.out.println("-----");

        IntStream.of(new int[]{5, 6, 7}).forEach(System.out::println);


        System.out.println("-----");

        //foreach的用法
        IntStream.of(new int[]{5, 6, 7}).forEach(x->{
            System.out.println("ceshi"+x);
        });

        System.out.println("-----");

        //范围从3-7,不包含8

        IntStream.range(3, 8).forEach(System.out::println);

        System.out.println("-----");

        //范围从3-8,包含8

        IntStream.rangeClosed(3, 8).forEach(System.out::println);

    }
}
