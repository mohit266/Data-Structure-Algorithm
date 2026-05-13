package com.dsa.Recursion;

import java.util.ArrayList;
import java.util.List;

public class CheckSubsequenceSum {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int k = 8;

        System.out.println(checkSubsequenceSumOptimised(arr, k));

    }

    public static boolean checkSubsequenceSumOptimised(int[] nums, int target) {
        int n = nums.length;
        return solve(0, n, nums, target);
    }

    public static boolean solve(int i, int n, int[] arr, int k) {
        if (k == 0) {
            return true;
        }
        if (k < 0) {
            return false;
        }
        if (i == n) {
            return false;
        }

        return solve(i + 1, n, arr, k - arr[i]) || solve(i + 1, n, arr, k);
    }



    public static boolean checkSubsequenceSum(int[] nums, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(0, k, nums.length, nums, new ArrayList<>(), ans);
        return !ans.isEmpty();
    }

    private static void backtrack(int index, int k, int n, int[] nums, List<Integer> current, List<List<Integer>> ans) {
        if (index == n) {
            if (current.stream().mapToInt(Integer::intValue).sum() == k){
                ans.add(new ArrayList<>(current));
            }
            return;
        }

        backtrack(index + 1, k, n, nums, current, ans);
        current.add(nums[index]);
        backtrack(index + 1, k, n ,nums, current, ans);

        current.remove(current.size() - 1);
    }

}
