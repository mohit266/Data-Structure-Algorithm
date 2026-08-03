package com.dsa.PatternWise.KadanesAlgo;

// 1186. Maximum Subarray Sum with One Deletion
public class MaxSubarraySumWithOneDeletion {

    public static void main(String[] args) {
        MaxSubarraySumWithOneDeletion m = new MaxSubarraySumWithOneDeletion();
        int[] nums = {1, -2, 0, 3};

        System.out.println(m.maximumSum(nums));
    }

    public int maximumSum(int[] arr) {
        int n = arr.length;
        int res = arr[0];

        int noDelete = arr[0];
        int oneDelete = Integer.MIN_VALUE;

        for (int i = 1; i < n; i++) {
            int prevNoDelete = noDelete;

            int v2;

            if (oneDelete == Integer.MIN_VALUE){
                v2 = arr[i];
            } else {
                v2 = oneDelete + arr[i];
            }

            noDelete = Math.max(arr[i], noDelete + arr[i]);
            oneDelete = Math.max(prevNoDelete, v2);

            res = Math.max(res, Math.max(noDelete, oneDelete));
        }

        return res;
    }

}
