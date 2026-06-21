package com.dsa.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetII {
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        System.out.println(subsetsWithDup(nums));
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrackSubsetII(0, nums, new ArrayList<>(), result);
        return result;
    }

    public static void backtrackSubsetII(int index, int[] nums, List<Integer> current, List<List<Integer>> ans){

        if (index == nums.length){
            ans.add(new ArrayList<>(current));
            return;
        }

        current.add(nums[index]);
        backtrackSubsetII(index+1, nums, current, ans);
        current.remove(current.size() - 1);

        int next = index + 1;
        while (next < nums.length && nums[next] == nums[index]) {
            next++;
        }
        backtrackSubsetII(next, nums, current, ans);
    }
}
