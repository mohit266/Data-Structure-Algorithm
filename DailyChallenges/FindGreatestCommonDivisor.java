package com.dsa.DailyChallenges;

import java.util.Arrays;

// 1979. Find Greatest Common Divisor of Array
public class FindGreatestCommonDivisor {

    public static void main(String[] args) {
        FindGreatestCommonDivisor f = new FindGreatestCommonDivisor();
        int[] nums = {2,5,6,9,10};

        System.out.println(f.findGCD(nums));
    }

    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        return (gcd(nums[0], nums[nums.length-1]));
    }

    public int gcd(int a, int b){
        while (a > 0 && b > 0){
            if (a > b){
                a = a % b;
            } else {
                b = b % a;
            }
        }

        if (a == 0) return b;
        return a;
    }

}
