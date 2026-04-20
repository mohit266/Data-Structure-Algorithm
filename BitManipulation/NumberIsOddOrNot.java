package com.dsa.BitManipulation;

public class NumberIsOddOrNot {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(isOdd(n));
    }

    public static boolean isOdd(int n) {
        return (n&1) != 0;
    }
}
