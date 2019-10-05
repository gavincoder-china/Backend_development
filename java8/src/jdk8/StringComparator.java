package jdk8;


import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StringComparator {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("zhangsan", "lisi", "wangwu", "zhaoliu");

//        Collections.sort(names, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o2.compareTo(o1);
//            }
//        });
//
//        System.out.println(names);

        // expression o2.compareTo(o1)
        // statement {return o2.compareTo(o1);}

        Collections.sort(names, (o1, o2) -> {return o2.compareTo(o1);});

        System.out.println(names);




    }


}
