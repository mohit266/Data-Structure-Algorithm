package com.dsa.Recursion;

public class PowXN {
    public static void main(String[] args) {
        double x = 2.00;
        int n = 10;

        System.out.println(myPow(x, n));

    }

    public static double myPow(double x, int n) {
        long num = n;
        if (n < 0){
            x = 1.0/x;
            num = -num;
        }
        return calculatePow(x, num);
    }


    public static double calculatePow(double x, long n){
        if (n == 0){
            return 1;
        }
        if (n == 1) return x;
        if ((n&1) == 1) {
            return x * calculatePow(x, n - 1);
        }
        return calculatePow(x*x, n/2);
    }

    public static double myPowBruteForce(double x, int n) {
        long num = n;
        double ans = 1;

        if (n < 0){
            x = 1.0/x;
            num = -num;
        }

        while (num > 0){
            if ((num&1) == 1){
                ans = ans * x;
                num = num - 1;
            } else {
                x = x* x;
                num = num / 2;
            }
        }

        return ans;
    }

}
