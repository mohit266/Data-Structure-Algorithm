package com.dsa.DailyChallenges;

public class RemovingMinAndMaxFromArray {

    public static void main(String[] args) {
        RemovingMinAndMaxFromArray r = new RemovingMinAndMaxFromArray();
        int [] nums = {2,10,7,5,4,1,8,6};

        System.out.println(r.minimumDeletions(nums));
    }


    public int minimumDeletions(int[] nums) {

        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        int max = Integer.MIN_VALUE;
        int maxIndex = -1;

        int n = nums.length;

        for (int i = 0; i < n; i++){

            if(nums[i] < min) {
                min = nums[i];
                minIndex = i+1;
            }

            if (nums[i] > max){
                max = nums[i];
                maxIndex = i+1;
            }
        }

        // from front
        int front = Math.max(minIndex, maxIndex);

        // from back
        int back = Math.max(n - minIndex + 1, n - maxIndex + 1);

        minIndex = Math.min(minIndex, n - minIndex + 1);
        maxIndex = Math.min(maxIndex, n - maxIndex + 1);

        int total = minIndex + maxIndex;

        return Math.min(total, Math.min(front, back));
    }
}
