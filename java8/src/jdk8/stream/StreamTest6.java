package jdk8.stream;


import java.util.IntSummaryStatistics;
import java.util.UUID;
import java.util.stream.Stream;

public class StreamTest6 {
    public static void main(String[] args) {
//        Stream<String> stream = Stream.generate(UUID.randomUUID()::toString);
//        stream.findFirst().ifPresent(System.out::println);

        Stream<Integer> stream = Stream.iterate(1, item -> item + 2).limit(6);

//        System.out.println(stream.filter(item -> item > 200).mapToInt(item -> item * 2).skip(2).limit(2).sum());

//        stream.filter(item -> item > 200).mapToInt(item -> item * 2).skip(2).limit(2).max().ifPresent(System.out::println);


//        IntSummaryStatistics summaryStatistics = stream.filter(item -> item > 2).
//                mapToInt(item -> item * 2).skip(2).limit(2).summaryStatistics();

//        System.out.println(summaryStatistics.getMin());
//        System.out.println(summaryStatistics.getCount());
//        System.out.println(summaryStatistics.getMax());

//        System.out.println(stream);
//        System.out.println(stream.filter(item -> item > 2));
//        System.out.println(stream.distinct());


        System.out.println(stream);
        Stream<Integer> stream2 = stream.filter(item -> item > 2);
        System.out.println(stream2);
        Stream<Integer> stream3 = stream2.distinct();
        System.out.println(stream3);


    }
}
