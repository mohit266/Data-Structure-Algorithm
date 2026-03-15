package com.dsaAtoZ.BasicRecursion;

public class SumOfFirstNNumbers {
    public static void main(String[] args) {
        System.out.println(nNumbersSum(5));
    }

    public static int nNumbersSum(int N) {
        if (N == 0){
            return 0;
        }
        return N + nNumbersSum(N-1);
    }
}
