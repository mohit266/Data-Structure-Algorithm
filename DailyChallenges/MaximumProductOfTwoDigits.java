package com.dsa.DailyChallenges;

public class MaximumProductOfTwoDigits {

    public static void main(String[] args) {
        MaximumProductOfTwoDigits m = new MaximumProductOfTwoDigits();

        System.out.println(m.maxProduct(20));
    }

    public int maxProduct(int n) {

        int highest = 0;
        int secondHighest = 0;

        while (n >= 1){

            int num = n % 10;

            if (num > highest){
                secondHighest = highest;
                highest = num;
            } else if (num > secondHighest) {
                secondHighest = num;
            }
            n = n / 10;
        }
        return highest * secondHighest;
    }

}
