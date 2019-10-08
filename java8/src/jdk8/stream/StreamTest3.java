package jdk8.stream;



import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest3 {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

        //这个是转换生成新的list
        System.out.println(list.stream().map(i -> 2 * i).collect(Collectors.toList()));



        //这个是聚合,将所有元素聚合成一条数据
        System.out.println(list.stream().map(i -> 2 * i).reduce(0, Integer::sum));

    }
}
