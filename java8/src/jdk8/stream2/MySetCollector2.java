package jdk8.stream2;


import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class MySetCollector2<T> implements Collector<T, Set<T>, Map<T, T>> {

    @Override
    public Supplier<Set<T>> supplier() {
        System.out.println("supplier invoked!");

//        return HashSet<T>::new;

        /**
         *     A a1 = supplier.get();
         *     accumulator.accept(a1, t1);
         *     accumulator.accept(a1, t2);
         *     R r1 = finisher.apply(a1);  // result without splitting
         *
         *     A a2 = supplier.get();
         *     accumulator.accept(a2, t1);
         *     A a3 = supplier.get();
         *     accumulator.accept(a3, t2);
         *     R r2 = finisher.apply(combiner.apply(a2, a3));  // result with splitting
         *
         */
        return () -> {
            System.out.println("-----------");
            return new HashSet<T>();
        };

    }

    @Override
    public BiConsumer<Set<T>, T> accumulator() {
        System.out.println("accumulator invoked!");

        return (set, item) -> {
            System.out.println("accumulator: " + set  + ", " + Thread.currentThread().getName());
            set.add(item);
        };
    }

    @Override
    public BinaryOperator<Set<T>> combiner() {
        System.out.println("combiner invoked!");

        return (set1, set2) -> {
            System.out.println("set1: " + set1);
            System.out.println("set2: " + set2);
            set1.addAll(set2);
            return set1;
        };
    }

    @Override
    public Function<Set<T>, Map<T, T>> finisher() {
        System.out.println("finisher invoked!");

        return set -> {
            Map<T, T> map = new TreeMap<>();
            set.stream().forEach(item -> map.put(item, item));
            return map;
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        System.out.println("characteristics invoked!");

        return Collections.unmodifiableSet(EnumSet.of(Characteristics.UNORDERED));
    }

    public static void main(String[] args) {

        System.out.println(Runtime.getRuntime().availableProcessors());

        for(int i = 0; i < 1; ++i) {

            List<String> list = Arrays.asList("hello", "world", "welcome", "hello", "a", "b", "c", "d", "e", "f", "g");
            Set<String> set = new HashSet<>();
            set.addAll(list);

            System.out.println("set: " + set);

            Map<String, String> map = set.parallelStream().collect(new MySetCollector2<>());

            System.out.println(map);
        }

    }
}
