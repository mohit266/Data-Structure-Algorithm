package com.dsa.BitManipulation;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        int subsets = (1 << nums.length) - 1;

        for (int i = 0; i <= subsets; i++){
            List<Integer> ls = new ArrayList<>();

            for (int j = 0; j < nums.length; j++){
                if ((i & (1 << j)) != 0){
                    ls.add(nums[j]);
                }
            }
            result.add(ls);
        }
        return result;
    }
}
