package com.dsa.JavaPrep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparatorAndComparable {

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        Student st1 = new Student(1, "Mohit");
        Student st2 = new Student(2, "Rahul");
        Student st4 = new Student(2, "Dinesh");

        students.add(st1);
        students.add(st2);
        students.add(st4);

        // Comparator
        // 1st Method using lambda
        Collections.sort(students, (s1, s2) -> s1.getId() - s2.getId());

        // 2nd Method using Method Reference
        Comparator<Student> byIdAndName = Comparator.comparing(Student::getId).thenComparing(Student::getName);
        Collections.sort(students, byIdAndName);
        System.out.println(students);

        // 3rd by create new manual comparator class.
        StudentComparator byName = new StudentComparator();
        Collections.sort(students, byName);
        System.out.println(students);



        // Comparable - Student class implements Comparable interface.
        Collections.sort(students);
        System.out.println(students);
    }

}
