package com.dsa.DailyChallenges;

public class MaxPairStrengthUsingGCD {

    public static void main(String[] args) {
        MaxPairStrengthUsingGCD m = new MaxPairStrengthUsingGCD();
        int[] nums = {10, 4, 19};

        System.out.println(m.maxPairStrength(nums));
    }


    public long maxPairStrength(int[] nums) {
        long max = 0;

        for (int i = 0; i < nums.length; i++){
            for (int j = 0; j < nums.length; j++){
                if (i == j){
                    continue;
                }
                int gcd = getGcd(nums[i], nums[j]);

                long squareOfGcd = (long) gcd * gcd;
                long multiplication = (long) nums[i] * nums[j];

                max = Math.max(max, (multiplication / squareOfGcd));
            }
        }
        return max;
    }

    public int getGcd(int n1, int n2){

        while (n1 > 0 && n2 > 0){
            if (n1 > n2){
                n1 = n1 % n2;
            } else {
                n2 = n2 % n1;
            }
        }

        if (n1 == 0) return n2;

        return n1;
    }

}
