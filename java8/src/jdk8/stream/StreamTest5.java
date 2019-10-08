package jdk8.stream;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest5 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "helloworld", "test");
        list.stream().map(String::toUpperCase).collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("----------");

        List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5);
        list2.stream().map(item -> item * item).collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("----------");

        Stream<List<Integer>> stream = Stream.of(Arrays.asList(1),
                Arrays.asList(2, 3), Arrays.asList(4, 5, 6));

        stream.flatMap(theList -> theList.stream()).map(item -> item * item).forEach(System.out::println);

    }
}
