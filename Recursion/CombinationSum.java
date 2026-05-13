package com.dsa.Recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 4};
        int target = 7;

        System.out.println(combinationSum(nums, target));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backTrackCombinationSum(0, candidates, target, new ArrayList<>(), ans);
        return ans;
    }

    public static void backTrackCombinationSum(int index, int[] nums, int target, List<Integer> current,
                                               List<List<Integer>> ans){

        if (target == 0){
            ans.add(new ArrayList<>(current));
            return;
        }

        if (target < 0 || index == nums.length){
            return;
        }

        current.add(nums[index]);
        backTrackCombinationSum(index, nums, target - nums[index], current, ans);
        current.remove(current.size() - 1);
        backTrackCombinationSum(index + 1, nums, target, current, ans);
    }
}
