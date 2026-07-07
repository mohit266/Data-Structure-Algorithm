package com.dsa.DailyChallenges;

public class ConcatenateNonZeroDigitsAndMultiplyBySumI {

    public static void main(String[] args) {
        ConcatenateNonZeroDigitsAndMultiplyBySumI c = new ConcatenateNonZeroDigitsAndMultiplyBySumI();

        int n = 10203004;
        System.out.println(c.sumAndMultiply(n));
    }

    public long sumAndMultiply(int n) {
        long num = n;
        long ans = 0;
        long x = 0;

        long div = 1;

        while (num/div >= 10){
            div *= 10;
        }

        while (div > 0){
            int digit = (int) (num / div);
            num = num % div;
            div = div / 10;

            if (digit > 0){
                x = x + digit;
                ans = ans * 10 + (long) digit ;
            }
        }
        return ans * x;
    }

}
