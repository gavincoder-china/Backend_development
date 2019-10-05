package jdk8.stream2;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest3 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "welcome");

//        System.out.println(list.getClass());

//        list.stream().forEach(System.out::println);

        Stream<String> stream = list.stream();

        System.out.println("1111");

        Stream<String> stream2 = stream.map(item -> item + "_abc");

        System.out.printf("2222");

        stream2.forEach(System.out::println);


        System.out.println("------");

        list.stream().forEach(System.out::println);

        System.out.println("------");

        list.forEach(System.out::println);


    }
}
