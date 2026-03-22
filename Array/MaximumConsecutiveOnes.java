package com.dsaAtoZ.Array;

public class MaximumConsecutiveOnes {
    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 0, 1, 1, 1, 0};
        System.out.println(findMaxConsecutiveOnes(arr));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int count= 0;
        int max = 0;

        for (int i =0; i<nums.length; i++){
            if (nums[i] == 1){
                count++;
                if (count > max) {
                    max = count;
                }
            } else {
                count = 0;
            }

        }
        return max;
    }

}
