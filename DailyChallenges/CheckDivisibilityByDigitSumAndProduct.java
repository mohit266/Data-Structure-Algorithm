package com.dsa.DailyChallenges;

public class CheckDivisibilityByDigitSumAndProduct {

    public static void main(String[] args) {
        CheckDivisibilityByDigitSumAndProduct c = new CheckDivisibilityByDigitSumAndProduct();
        int n = 99;

        System.out.println(c.checkDivisibility(n));
    }


    public boolean checkDivisibility(int n) {

        int digit = n;

        int sum = 0;
        long product = 1;

        while (n >= 1){
            int rem = n % 10;
            sum += rem;
            product = rem * product;
            n = n/10;
        }

        return (digit % (sum + product)) == 0;
    }
}
