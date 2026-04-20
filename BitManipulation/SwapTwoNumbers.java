package com.dsa.BitManipulation;

import java.util.Arrays;

public class SwapTwoNumbers {
    public static void main(String[] args) {
        int a = 5;
        int b = 4;

        System.out.println(Arrays.toString(swap(a, b)));
    }

    public static int[] swap(int a, int b) {
        a = a ^ b;
        b = a ^ b;  // b = a^b^b => a;
        a = a ^ b;  // a = a^b^a => b;

        return new int [] {a, b};
    }
}
