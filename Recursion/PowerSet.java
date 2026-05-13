package com.dsa.Recursion;

import java.util.ArrayList;
import java.util.List;

class PowerSet {

    public static void main(String[] args) {
        PowerSet p = new PowerSet();
        int[] nums = {1, 2, 3};

        System.out.println(p.powerSet(nums));

    }


    public List<List<Integer>> powerSet(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtrack(0, nums.length, nums, current, ans);
        return ans;
    }

    private void backtrack(int index, int n, int[] nums, List<Integer> current, List<List<Integer>> ans) {
        if (index == n) {
            ans.add(new ArrayList<>(current));
            return;
        }

        backtrack(index + 1, n, nums, current, ans);
        current.add(nums[index]);
        backtrack(index + 1, n, nums, current, ans);
        current.remove(current.size() - 1);
    }

}
