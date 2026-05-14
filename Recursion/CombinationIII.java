package com.dsa.Recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationIII {
    public static void main(String[] args) {
        int k = 3;
        int n = 7;
        System.out.println(combinationSum3(k, n));
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        backtrackComSumIII(n, 1, nums, k, ans);
        return ans;
    }
    private static void backtrackComSumIII(int sum, int last, List<Integer> nums, int k, List<List<Integer>> ans) {
        if (sum == 0 && nums.size() == k) {
            ans.add(new ArrayList<>(nums));
            return;
        }

        if (sum <= 0 || nums.size() > k) return;

        for (int i = last; i <= 9; i++) {
            if (i <= sum) {
                nums.add(i);
                backtrackComSumIII(sum - i, i + 1, nums, k, ans);
                nums.remove(nums.size() - 1);
            } else {
                break;
            }
        }
    }
}
