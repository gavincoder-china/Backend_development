package jdk8.stream;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest1 {

    public static void main(String[] args) {
        Stream stream1 = Stream.of("hello", "world", "hello world");

        //数组生成stream流的方法
        String[] myArray = new String[]{"hello", "world", "hello world"};
        Stream stream2 = Stream.of(myArray);
        Stream stream3 = Arrays.stream(myArray);

        //集合生成stream流的方法
        List<String> list = Arrays.asList(myArray);
        Stream stream4 = list.stream();

    }
}
