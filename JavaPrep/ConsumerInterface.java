package com.dsa.JavaPrep;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerInterface {
    public static void main(String[] args) {

        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("ABC");

        Consumer<List<Integer>> consumer1 = li -> {
            for (int n : li){
                System.out.println(n + 100);
            }
        };

        Consumer<List<Integer>> consumer2 = li -> {
            for (int n : li){
                System.out.println(n);
            }
        };

        consumer2.andThen(consumer1).accept(Arrays.asList(1, 2, 3, 4));
    }
}
