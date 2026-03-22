package com.dsa.BasicRecursion;

// https://leetcode.com/problems/fibonacci-number/description/
public class FibonacciNumber {

    // 0 1 1 2 3 5 8 13 21......
    public static void main(String[] args) {
        System.out.println(getFibonacciNum(8));
        System.out.println(getFibNum(8));
    }

    // Using for loop.
    public static int getFibNum(int n){
        if (n <= 1) return n;
        int fiboNum = 0;
        int lastNum = 1;
        int lastSecond = 0;
        for (int i=2; i<=n; i++){
            fiboNum = lastNum + lastSecond;
            lastSecond = lastNum;
            lastNum = fiboNum;
        }
        return fiboNum;
    }

    // Using recursion.
    public static int getFibonacciNum(int n){
        if (n <= 1){
            return n;
        }
        return getFibonacciNum(n-1) + getFibonacciNum(n - 2);
    }

}
