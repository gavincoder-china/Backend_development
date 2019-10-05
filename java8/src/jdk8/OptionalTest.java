package jdk8;


import java.util.Optional;

public class OptionalTest {

    public static void main(String[] args) {
        Optional<String> optional = Optional.ofNullable("hello");

//        if(optional.isPresent()) {
//            System.out.println(optional.get());
//        }

        optional.ifPresent(item -> System.out.println(item)); //推荐的Optional使用方式
        System.out.println("-------");

        System.out.println(optional.orElse("world"));
        System.out.println("---------");

        System.out.println(optional.orElseGet(() -> "nihao"));



    }
}
