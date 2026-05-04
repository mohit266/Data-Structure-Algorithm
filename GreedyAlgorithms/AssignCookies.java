package com.dsa.GreedyAlgorithms;

import java.util.Arrays;

public class AssignCookies {
    public static void main(String[] args) {
        AssignCookies assignCookies = new AssignCookies();
        int[] Student = {10,9,8,7};
        int[] Cookie = {5,6,7,8};
        System.out.println(assignCookies.findMaximumCookieStudents(Student, Cookie));
    }

    public int findMaximumCookieStudents(int[] Student, int[] Cookie) {
        int sizeOfStudent = Student.length;
        int sizeOfCookie = Cookie.length;

        Arrays.sort(Student);
        Arrays.sort(Cookie);

        int l = 0;
        int r = 0;

        while (l < sizeOfStudent && r < sizeOfCookie){
            if (Student[l] <= Cookie[r]){
                l++;
            }
            r++;
        }
        return l;
    }
}
