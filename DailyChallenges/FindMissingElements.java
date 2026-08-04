package com.dsa.DailyChallenges;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class FindMissingElements {

    public static void main(String[] args) {

        FindMissingElements f = new FindMissingElements();

        int[] nums = {7, 8, 5, 9};
        System.out.println(f.findMissingElements(nums));
    }


    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> ls = new ArrayList<>();

        int[] hash = new int[101];

        for (int n : nums){
            hash[n]++;
        }

        Arrays.sort(nums);

        int n = nums.length;
        int smallestEle = nums[0];
        int largestEle = nums[n-1];

        for (int i = smallestEle + 1; i < largestEle; i++) {
            if (hash[i] == 0){
                ls.add(i);
            }
        }
        return ls;
    }
}
