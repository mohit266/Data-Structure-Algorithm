package com.dsa.JavaPrep;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPI {

    public static void main(String[] args) {

        // Method to get stream


        // 1
        int[] array = {1, 2, 3, 4, 5};
        IntStream stream = Arrays.stream(array);

        // 2
        List<String> ls = Arrays.asList("Apple", "Banana", "Cherry");
        Stream<String> lsStream = ls.stream();

        // 3
        Stream<Integer> intStream = Stream.of(1, 2, 3);

        // 4
        Stream<Integer> limit = Stream.iterate(0, n -> n + 1).limit(10);

        // 5
        Stream<Long> limit1 = Stream.generate(() -> (long) Math.random()).limit(10);


        List<Integer> list = Stream
                .iterate(0, n -> n + 1)
                .limit(11)
                .filter(n -> n % 2 == 0)
                .map(n -> n * 2)
                .skip(1)
                .peek(System.out::println)
                .toList();

        System.out.println(list);

        ArrayList<Student> students = new ArrayList<>();

        Student st1 = new Student(1, "Mohit", 20000);
        Student st2 = new Student(2, "Rahul", 15000);
        Student st4 = new Student(2, "Dinesh", 20000);

        students.add(st1);
        students.add(st2);
        students.add(st4);

        Comparator<Student> comparator = (a, b) -> Integer.compare(b.getSalary(), a.getSalary());

        Student secondHighest  = students.stream()
                        .sorted(Comparator.comparing(Student::getSalary)
                        .reversed())
                        .distinct()
                        .skip(1)
                        .findFirst()
                        .orElse(null);

        System.out.println(secondHighest);



    }
}
