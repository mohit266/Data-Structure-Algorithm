package com.dsa.BitManipulation;

public class CheckIfNumIsPowerOfTwo {
    public static void main(String[] args) {
        int n = 16;
        System.out.println(isPowerOfTwo(n));
    }

    public static boolean isPowerOfTwo(int n) {
        return (n&(n-1)) == 0;
    }
}
