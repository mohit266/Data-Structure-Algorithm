package com.dsa.DailyChallenges;

import java.util.Arrays;

public class MaximumElementAfterDecreasingAndRearranging {

    public static void main(String[] args) {
        MaximumElementAfterDecreasingAndRearranging m = new MaximumElementAfterDecreasingAndRearranging();

        int[] arr = {2,2,1,2,1};
        System.out.println(m.maximumElementAfterDecrementingAndRearranging(arr));
    }

    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        arr[0] = 1;
        for (int i = 1; i < arr.length; i++){
            int diff = Math.abs(arr[i] - arr[i-1]);

            if (diff > 1){
                arr[i] = arr[i-1] + 1;
            }
        }
        return arr[arr.length-1];
    }
}
