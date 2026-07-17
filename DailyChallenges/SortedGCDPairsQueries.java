package com.dsa.DailyChallenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortedGCDPairsQueries {

    public static void main(String[] args) {
        SortedGCDPairsQueries g = new SortedGCDPairsQueries();

        int[] nums = {2,3,4};
        long[] queries = {0,2,2};

        System.out.println(Arrays.toString(g.gcdValues(nums, queries)));
    }


    public int[] gcdValues(int[] nums, long[] queries) {
        int max = 1;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        long[] gcdDp = new long[max + 1];
        for (int num : nums) {
            gcdDp[num]++;
        }

        for (int i = 1; i <= max; i++) {
            long count = 0;
            for (int j = i; j <= max; j = j + i) {
                count += gcdDp[j];
            }
            gcdDp[i] = ((count - 1) * count) / 2;
        }

        for (int i = max; i > 0; i--) {
            for (int j = i + i; j <= max; j = j + i) {
                gcdDp[i] -= gcdDp[j];
            }
        }

        for (int i = 1; i <= max; i++) {
            gcdDp[i] += gcdDp[i - 1];
        }

        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            result[i] = binarySearch(max, gcdDp, queries[i] + 1);
        }

        return result;
    }

    private int binarySearch(int n, long[] arr, long val) {
        int l = 1;
        int r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] < val) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }


    // Logic is correct but giving TLE
    public int[] gcdValuesBruteForce(int[] nums, long[] queries) {
        List<Integer> result = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), result);
        Collections.sort(result);

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++){
            ans[i] = result.get((int) queries[i]);
        }

        return ans;
    }


    public void backtrack(int index, int[] nums, List<Integer> ls, List<Integer> result){

        if (ls.size() > 2){
            return;
        }

        if (index == nums.length || ls.size() == 2){
            if (ls.size() == 2){
                result.add(gcd(ls.get(0), ls.get(1)));
            }
            return;
        }

        ls.add(nums[index]);
        backtrack(index + 1, nums, ls, result);
        ls.remove(ls.size() - 1);
        backtrack(index + 1, nums, ls, result);

    }


    public int gcd (int a, int b){
        while (a >0 && b > 0){
            if (a > b){
                a = a % b;
            } else {
                b = b % a;
            }
        }

        if (a == 0) return b;
        return a;
    }

}
