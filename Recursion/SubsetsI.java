package com.dsa.Recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsetsI {
    public static void main(String[] args) {
        int[] nums = {2, 3};
        System.out.println(subsetSums(nums));
    }

    public static List<Integer> subsetSums(int[] nums) {
        List<Integer> result = new ArrayList<>();

        backTrackSubsetI(0, nums, new ArrayList<>(), result);
        return result;
    }

    public static void backTrackSubsetI(int index, int[] nums, List<Integer> current, List<Integer> ans){

        if (index == nums.length){
            ans.add(current.stream().mapToInt(Integer::intValue).sum());
            return;
        }

        current.add(nums[index]);
        backTrackSubsetI(index + 1, nums, current, ans);
        current.remove(current.size() - 1);
        backTrackSubsetI(index + 1, nums, current, ans);
    }
}
