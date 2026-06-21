package com.dsa.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public static void main(String[] args) {
        int[] arr = {2, 1, 2, 7, 6, 1, 5};
        int k = 8;

        System.out.println(combinationSum2(arr, k));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(0, target, candidates, new ArrayList<>(), ans);
        return ans;
    }

    public static void backtrack(int index, int k, int[] nums, List<Integer> current, List<List<Integer>> ans){

        if (k == 0){
            ans.add(new ArrayList<>(current));
            return;
        }

        if (index == nums.length || k < 0){
            return;
        }

        current.add(nums[index]);
        backtrack(index + 1, k - nums[index], nums, current, ans);
        current.remove(current.size()-1);

        int next = index + 1;
        while (next < nums.length && nums[next] == nums[index]) {
            next++;
        }
        backtrack(next, k, nums, current, ans);
    }

}
