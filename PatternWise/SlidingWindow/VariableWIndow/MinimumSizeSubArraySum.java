package com.dsa.PatternWise.SlidingWindow.VariableWIndow;

// 209. Minimum Size Subarray Sum
public class MinimumSizeSubArraySum {

    public static void main(String[] args) {

        MinimumSizeSubArraySum m = new MinimumSizeSubArraySum();

        int target = 7;
        int [] nums = {2,3,1,2,4,3};

        System.out.println(m.minSubArrayLen(target, nums));
    }

    public int minSubArrayLen(int target, int[] nums) {

        int i = 0;
        int j = 0;

        int minLen = Integer.MAX_VALUE;

        int sum = 0;

        while (i <= j && j < nums.length){

            sum += nums[j];

            while (sum >= target){
                int left = nums[i];
                sum = sum - left;
                minLen = Math.min(minLen, j - i + 1);
                i++;
            }
            j++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }


}
