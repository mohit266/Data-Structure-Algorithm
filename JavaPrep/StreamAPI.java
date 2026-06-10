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

        // 1. Find even number in a list
        List<Integer> list1 = Arrays.asList(10,9,1,2,3,2,3,4,5,6,7,8);
        List<Integer> evenNumbers = list1.stream().filter(n -> n % 2 == 0).toList();
        System.out.println(evenNumbers);

        // 2. Find square of each number
        List<Integer> sq = list1.stream().map(n -> n * n).toList();
        System.out.println(sq);

        // 3. Sort list in ascending order.
        List<Integer> sortInAsc = list1.stream().sorted().toList();
        System.out.println(sortInAsc);

        // 4. Sort list in descending order.
        List<Integer> sortInDsc = list1.stream().sorted((a,b) -> b - a).toList();
        System.out.println(sortInDsc);

        // 5. Count elements in the list.
        long countEle = list1.stream().count();
        System.out.println(countEle);

        // 6. Find First Element
        int first = list1.stream().findFirst().get();
        System.out.println(first);

        // 7. Find Max Number
        int max = list1.stream().max(Integer::compare).get();
        System.out.println(max);

        // 8. Find Min Number
        int min = list1.stream().min(Integer::compare).get();
        System.out.println(min);

        // 9. Sum of all numbers
        int sum = list1.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);

        // 10. Average of all numbers
        double avg = list1.stream().mapToDouble(Integer::intValue).average().orElse(0);
        System.out.println(avg);

        List<String> list2 = Arrays.asList("abc","xaq","apple", "banana", "grapes");

        // 11. Convert list to upper case
        List<String> upperCas = list2.stream().map(String::toUpperCase).toList();
        System.out.println(upperCas);

        // 12. Remove duplicates from list.
        List<Integer> removeDuplicates = list1.stream().distinct().toList();
        System.out.println(removeDuplicates);

        // 13. Filter String with len > 3.
        List<String> filterWithLen = list2.stream().filter(s -> s.length() > 3).toList();
        System.out.println(filterWithLen);

        // 14. Join String with comma
        String joining = list2.stream().collect(Collectors.joining(","));
        System.out.println(joining);

        // 15. Check if any number is greater than 9.
        boolean ans = list1.stream().anyMatch(n -> n > 9);
        System.out.println(ans);

        // 16. Check if all numbers are positive.
        boolean positiveNum = list1.stream().allMatch(n -> n > 0);
        System.out.println(positiveNum);

        // 17. Check is no number is negative.
        boolean noNegativeNum = list1.stream().noneMatch(n -> n < 0);
        System.out.println(noNegativeNum);

        // 18. Find second-largest number.
        Optional<Integer> secondLargest = list1.stream().distinct().sorted((a,b) -> b - a).skip(1)
                .findFirst();
        secondLargest.ifPresent(System.out::println);

        // 19. Find Common Elements in two list.
        List<Integer> l1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> l2 = Arrays.asList(4, 5, 6, 7);

        List<Integer> common = l1.stream().filter(l2::contains).distinct().toList();
        System.out.println(common);

        // 20. Group string by first character.
        Map<Character, List<String>> mp = list2.stream().collect(Collectors.groupingBy(s ->s.charAt(0)));
        System.out.println(mp);

        // 21. Get Length of Each String.
        List<Integer> lengthOfEachString = list2.stream().map(String::length).toList();
        System.out.println(lengthOfEachString);

        // 22. Find elements start with A.
        List<String> elementsStartsWithA = list2.stream().filter(s -> s.toUpperCase().charAt(0) == 'A').toList();
        System.out.println(elementsStartsWithA);

        // 23. Convert list to Set using streams.
        Set<Integer> convSet = list1.stream().collect(Collectors.toSet());
        System.out.println(convSet);

        // 24. Convert List to Map
        ArrayList<Student> stds = new ArrayList<>();

        Student s1 = new Student(1, "Mohit", 20000);
        Student s2 = new Student(2, "Aman", 15000);
        Student s3 = new Student(3, "Dinesh", 20000);

        stds.add(s1);
        stds.add(s2);
        stds.add(s3);

        Map<Integer, String> stMp = stds.stream().collect(Collectors.toMap(Student::getId, Student::getName));
        System.out.println(stMp);

        // 25. Partition Even and Odd Numbers.
        Map<Boolean, List<Integer>> evenAndOdd = list1.stream().distinct().collect(Collectors.partitioningBy(n -> n%2 ==0));
        System.out.println("\n25. Partition Even and Odd Numbers :: "+evenAndOdd);

        // 26. Find duplicate elements in a list
        Set<Integer> duplicateElements = list1.stream()
                .collect(Collectors.groupingBy(n -> n, Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());

        System.out.println("\n26. Duplicate Elements :: " +duplicateElements);

        // 27. Sort List by custom object property
        List<Student> sorted = stds.stream().sorted((a,b) ->b.getId() - a.getId()).toList();
        System.out.println("\n27. Sort List :: " +sorted);

        // 28. Count frequency of elements in a list.
        Map<String, Long> freq = list2.stream().collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        System.out.println("\n28. Count frequency of elements :: " +freq);

        // 29. Find the Longest String
        List<String> words = Arrays.asList("Stream", "API", "is", "powerful");
        String maxLen = words.stream().sorted((a,b) -> b.length() - a.length()).findFirst().get();
        System.out.println("\n29. Find the Longest String :: " +maxLen);

        // 30. Count Frequency of Characters in a String
        String input = "success";
        Map<Character, Long> m = input.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        System.out.println("\n30. Count Frequency of Characters in a String :: "+m);
    }
}
