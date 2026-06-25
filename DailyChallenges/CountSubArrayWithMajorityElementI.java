package com.dsa.DailyChallenges;

public class CountSubArrayWithMajorityElementI {

    public static void main(String[] args) {
        int[]  nums = {1, 2, 2, 3};
        int target = 2;

        CountSubArrayWithMajorityElementI c = new CountSubArrayWithMajorityElementI();
        System.out.println(c.countMajoritySubarrays(nums, target));
    }

    public int countMajoritySubarrays(int[] nums, int target) {

        int count = 0;

        int n = nums.length;

        for (int i = 0; i < n; i++){
            int twoCount = 0;
            for (int j = i; j < n; j++){
                if (nums[j] == target){
                    twoCount++;
                }
                int len = j - i + 1;
                if (twoCount > (len / 2)){
                    count++;
                }
            }
        }

        return count;
    }

}
