package jdk8.stream;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest4 {

    public static void main(String[] args) {
//        Stream<String> stream = Stream.of("hello", "world", "helloworld");
//
////        String[] stringArray = stream.toArray(length -> new String[length]);
//
//        String[] stringArray = stream.toArray(String[]::new);
//        Arrays.asList(stringArray).forEach(System.out::println);


//        Stream<String> stream = Stream.of("hello", "world", "helloworld");
////        List<String> list = stream.collect(Collectors.toList());
////        List<String> list = stream.collect(() -> new ArrayList(), (theList, item) -> theList.add(item),
////                (theList1, theList2) -> theList1.addAll(theList2));
//        List<String> list = stream.collect(LinkedList::new, LinkedList::add, LinkedList::addAll);
//
//        list.forEach(System.out::println);

//        Stream<String> stream = Stream.of("hello", "world", "helloworld");
//        List<String> list = stream.collect(Collectors.toCollection(ArrayList::new));
//        list.forEach(System.out::println);

//        Stream<String> stream = Stream.of("hello", "world", "helloworld");
//        Set<String> set = stream.collect(Collectors.toCollection(TreeSet::new));
//        System.out.println(set.getClass());
//
//        set.forEach(System.out::println);

        Stream<String> stream = Stream.of("hello", "world", "helloworld");
        String str = stream.collect(Collectors.joining()).toString();
        System.out.println(str);



    }
}
