package com.dsa.DailyChallenges;

import java.util.Arrays;

public class SumOfGCDOfFormedPairs {

    public static void main(String[] args) {
        SumOfGCDOfFormedPairs s = new SumOfGCDOfFormedPairs();
        int[] nums = {3, 6, 2, 8};

        System.out.println(s.gcdSum(nums));
    }

    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] prefixGcd = new int[n];
        long max = -1;

        for (int i = 0; i < n; i++){
            int num = nums[i];

            if (num > max){
                max = num;
            }
            prefixGcd[i] = gcd(num, max);
        }

        Arrays.sort(prefixGcd);

        long sum = 0;
        int low = 0;
        int high = n - 1;

        while (low < high){
            sum = sum + gcd(prefixGcd[low], prefixGcd[high]);
            low++;
            high--;
        }

        return sum;

    }


    public int gcd(long n1, long n2){

        while (n1 > 0 && n2 > 0){
            if (n1 > n2){
                n1 = n1 % n2;
            } else {
                n2 = n2 % n1;
            }
        }

        if (n1 == 0) {
            return (int) n2;
        }
        return (int) n1;
    }

}
