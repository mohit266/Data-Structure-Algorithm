package com.dsa.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        int[] arr = {1, -2, 3, 5, 7, 9};
        System.out.println(fourSum(arr, 7));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        int n = nums.length;

        for (int i = 0; i < n; i++){
            if (i > 0 && nums[i] == nums[i-1]) continue;

            for (int j = i+1; j < n; j++){
                if (j > i+1 && nums[j] == nums[j-1]) continue;

                int k = j+1;
                int l = n-1;

                while (k < l){
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];

                    if (sum == target){
                        List<Integer> ls = List.of(nums[i], nums[j], nums[k], nums[l]);
                        ans.add(ls);
                        k++;
                        l--;

                        while (k < l && nums[k] == nums[k-1]) k++;
                        while (k < l && nums[l] == nums[l+1]) l--;
                    } else if (sum < target){
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }
        return ans;
    }

}
