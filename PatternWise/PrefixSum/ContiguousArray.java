package com.dsa.PatternWise.PrefixSum;

import java.util.HashMap;
import java.util.Map;

// 525. Contiguous Array
public class ContiguousArray {

    public static void main(String[] args) {
        ContiguousArray c = new ContiguousArray();
        int[] nums = {0,1,1,1,1,1,0,0,0};

        System.out.println(c.findMaxLength(nums));
    }

    public int findMaxLength(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int maxlen = 0, count = 0;

        for (int i = 0; i < nums.length; i++){
            int n = nums[i] == 1 ? 1 : -1;

            count = count + n;

            if (map.containsKey(count)){
                maxlen = Math.max(maxlen, (i - map.get(count)));
            } else {
                map.put(count, i);
            }
        }
        return maxlen;

    }
}
