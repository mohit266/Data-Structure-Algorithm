package com.dsa.JavaPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionInterface {
    public static void main(String[] args) {

        // It is also an Functional Interface. Unlike predicate, it returns value;
        Function<String, Integer> getLengthOfString = x -> x.length();
        System.out.println(getLengthOfString.apply("ABC"));


        Student s1 = new Student(1, "A");
        Student s2 = new Student(2, "B");
        Student s3 = new Student(3, "A");

        List<Student> studentList = Arrays.asList(s1, s2, s3);

        // Function to get list of student whose name start with letter A
        Function<String, String> checkString = s -> s.substring(0,1);

        Function<List<Student>, List<Student>> listOfStudentWithLetterA = ls -> {
            List<Student> studentList1 = new ArrayList<>();
            for (Student s : ls){
                if (checkString.apply(s.getName()).equalsIgnoreCase("A")){
                    studentList1.add(s);
                }
            }
            return studentList1;
        };

        System.out.println(listOfStudentWithLetterA.apply(studentList));

        Function<Integer, Integer> function1 = x -> 2 * x;
        Function<Integer,Integer> function2 = x -> x * x * x;

        int res = function1.andThen(function2).apply(3);
        System.out.println(res);

        int newRes = function2.andThen(function1).apply(3);
        System.out.println(newRes);

        // Instead of using it opposite we can use compose method
        // Below and above will return same result.

        int usingCompose = function1.compose(function2).apply(3);
        System.out.println(usingCompose);

        // Identity method returns output what we are giving it as input.
        Function<String, String> identityFunction = Function.identity();
        System.out.println(identityFunction.apply("ABC"));


    }

}
