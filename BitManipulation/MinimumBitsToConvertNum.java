package com.dsa.BitManipulation;

public class MinimumBitsToConvertNum {
    public static void main(String[] args) {
        System.out.println(minBitsFlip(10,7));
    }

    public static int minBitsFlip(int start, int goal) {

        int num = start ^ goal;

        int count = 0;

        for (int i = 0; i < 32; i++) {
            count += (num & 1);
            num = num >> 1;
        }
        return count;
    }
}
