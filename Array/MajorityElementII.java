package com.dsa.Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MajorityElementII {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 1, 3, 2, 2};
        System.out.println(majorityElement(arr));
    }

    public static List<Integer> majorityElement(int[] nums) {
        int n = nums.length;

        int count1 = 0;
        int element1 = Integer.MIN_VALUE;

        int count2 = 0;
        int element2 = Integer.MIN_VALUE;

        for (int i =0; i < n; i++){
            if (count1 == 0 && element2 != nums[i]){
                element1 = nums[i];
                count1 = 1;
            } else if (count2 == 0 && element1 != nums[i]) {
                element2 = nums[i];
                count2 = 1;
            } else if (element1 == nums[i]) {
                count1++;
            } else if (element2 == nums[i]){
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        int mini = (n/3)+1;

        count1 = 0;
        count2 = 0;

        for (int i=0; i<n; i++){
            if (nums[i] == element1){
                count1++;
            }

            if (nums[i] == element2){
                count2++;
            }
        }

        List<Integer> ls = new ArrayList<>();
        if (count1 >= mini){
            ls.add(element1);
        }
        if(count2 >= mini){
            ls.add(element2);
        }
        Collections.sort(ls);
        return ls;
    }
}



