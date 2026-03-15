package com.dsaAtoZ.BasicRecursion;

public class PrintNTimes {
    public static void main(String[] args) {
        printNTime(5);
        printNTimeSecondApproach(1,5);
        printNumberNTimes(5);
        printNumber(1,5);
    }

    public static void printNTime(int n){
        if (n < 1){
            return;
        }
        n--;
        System.out.println("Recursion");
        printNTime(n);
    }

    public static void printNTimeSecondApproach(int i, int n){
        if (i > n){
            return;
        }
        System.out.println("Recursion");
        printNTimeSecondApproach(i+1, n);
    }

    // Using backtrack
    public static void printNumberNTimes(int i){
        if (i < 1){
            return;
        }
        printNumberNTimes(i-1);
        System.out.println(i);
    }

    public static void printNumber(int i, int n){
        if (i > n){
            return;
        }
        printNumber(i+1, n);
        System.out.println(i);
    }



}


