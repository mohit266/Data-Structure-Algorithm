package com.dsa.BitManipulation;

public class CheckIthBitIsSetOrNot {
    public static void main(String[] args) {
        int n = 5; // 0101  --> ith bit == 1;
        int i = 0;

        System.out.println(checkIthBit(n,i));
    }

    public static boolean checkIthBit(int n, int i) {
        // Using left shift
        return (n&(1<<i))!= 0;

        // Using right shift
//        return (((n>>i)&1)!=0);
    }
}
