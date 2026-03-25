package com.dsa.Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountSubArraysWithXOR {
    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 6, 4};
        int k = 6;
        System.out.println(subArraysWithXorKOptimalSol(arr, k));
    }

    public static int subArraysWithXorKOptimalSol(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        int xor = 0;
        int count = 0;

        // Base case: XOR = 0 occurs once
        map.put(0, 1);

        for (int num : nums) {
            xor ^= num;

            // Check if (xor ^ k) exists
            int target = xor ^ k;
            if (map.containsKey(target)) {
                count += map.get(target);
            }

            // Store current XOR in map
            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }

        return count;
    }

    public static int subArraysWithXorK(int[] nums, int k) {
        int i = 0;
        int n = nums.length;
        int count = 0;
        List<List<Integer>> subArraysList = new ArrayList<>();

        while (i < n){
            int sum= 0;
            int j = i;
            while (j < n){
                sum = sum ^ nums[j];

                if (sum == k){
                    List<Integer> ls = new ArrayList<>();
                    for (int a = i; a<=j; a++){
                        ls.add(nums[a]);
                    }
                    subArraysList.add(ls);
                    count++;
                }

                j++;
            }
            i++;
        }
        return subArraysList.size();
    }


}
