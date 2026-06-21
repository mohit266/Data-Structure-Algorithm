package com.dsa.DailyChallenges;

public class ValidSubArrayWithMatchingSumDigitsI {

    public static void main(String[] args) {
        int[] nums = {1000000000,1,1000000000,1,1000000000,1,1000000000};
        int x = 3;

        ValidSubArrayWithMatchingSumDigitsI p = new ValidSubArrayWithMatchingSumDigitsI();
        System.out.println(p.countValidSubarrays(nums, x));
    }

    public int countValidSubarrays(int[] nums, int x) {

        int count = 0;

        for (int i = 0; i < nums.length; i++){
            long sum = 0;
            for (int j = i; j < nums.length; j++){
                sum += nums[j];
                if (firsAndLastDigitEqualToK(sum, x)){
                    count++;
                }
            }
        }
        return count;
    }

    public boolean firsAndLastDigitEqualToK(long num, int k){
        int lastDigit = (int) (num % 10);

        long firstDigit = num;

        while(firstDigit >= 10){
            firstDigit = firstDigit/10;
        }
        return firstDigit == k && lastDigit == k;
    }
}
