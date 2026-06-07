package com.dsa.JavaPrep;

import java.util.function.Predicate;

public class PredicateInterface {

    public static void main(String[] args) {

        // Predicate -> Functional Interface
        // It is a boolean-valued function. It only checks condition
        Predicate<Integer> predicate = x -> x > 100;

        System.out.println(predicate.test(10));
        System.out.println(predicate.test(200));

        Predicate<String> startWithLetterM = x -> x.toUpperCase().charAt(0) == 'M';

        if (startWithLetterM.test("Mohit")){
            System.out.println("True");
        }

        Student s1 = new Student(1, "Mohit");
        Student s2 = new Student(2, "Rahul");

        Predicate<Student> studentPredicate = x -> x.getId() >  1;
        System.out.println(studentPredicate.test(s2));

        // AND Operation in Predicate
        Predicate<String> endsWithLetterT = x -> x.toUpperCase().charAt(x.length() - 1) == 'T';
        Predicate<String> andOperation = startWithLetterM.and(endsWithLetterT);

        System.out.println(andOperation.test("Mohit"));
        System.out.println(andOperation.test("Mohit Suthar"));


        // OR Operation in Predicate
        Predicate<String> orOperation = startWithLetterM.or(endsWithLetterT);

        System.out.println(orOperation.test("Mohit Suthar"));

        // Negate
        System.out.println(startWithLetterM.negate().test("Mohit"));


        // isEqual
        Predicate<Object> p = Predicate.isEqual("Mohit");
        System.out.println(p.test("Mohit"));

    }
}
