package com.dsaAtoZ.BasicRecursion;

public class FactorialOfN {
    // if n = 3 then factorial of 3 is 1*2*3 = 6.

    public static void main(String[] args) {
        System.out.println(factorialOfN(3));
    }

    public static int factorialOfN(int n){
        if (n == 0){
            return 1;
        }
        return n * factorialOfN(n-1);
    }

}
