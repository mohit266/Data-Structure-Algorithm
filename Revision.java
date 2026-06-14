package com.dsa;

import java.util.*;

public class Revision {
    public static void main(String[] args) {
        int num1 = 120;
        int num2 = 130;

        Revision rev = new Revision();

//        System.out.println(rev.totalWaviness(num1, num2));

//        int[] arr = {4,2,5,1};
//        System.out.println(rev.maxTotalValue(arr, 3));

        int[] nums = {1,1};
        System.out.println(Arrays.toString(rev.findErrorNums(nums)));

    }

    public List<Integer> replaceWithRank(List<Integer> arr) {
        List<Integer> sortedLs = arr.stream().distinct().sorted().toList();

        arr.replaceAll(o -> sortedLs.indexOf(o) + 1);

        return arr;
    }

    public int[] findErrorNums(int[] nums) {
        int duplicateNum = -1;
        boolean[] hash = new boolean[10];



        for (int i = 0; i < nums.length; i++){
            if (hash[nums[i]]){
                duplicateNum = nums[i];
                break;
            }
            hash[nums[i]] = true;
        }

        int missingNum = -1;

        for (int i = 1; i < nums.length + 1; i++){
            if (nums[i-1] != i){
                missingNum = i;
                break;
            }
        }

        return new int[]{duplicateNum,missingNum};
    }

    public long maxTotalValue(int[] nums, int k) {
        return countTotalSubArray(nums, k) + countTotalSubArray(nums, k -1);
    }

    public long countTotalSubArray(int[] nums, int k){
        int n = nums.length;
        int left = 0;
        int right = 0;

        int count = 0;

        HashMap<Integer, Integer> mp = new HashMap<>();

        if (k <= 0){
            return 0;
        }

        while(right < n){
            int val = nums[right];

            mp.put(val, mp.getOrDefault(val, 0) + 1);

            while (mp.size() > k){
                mp.put(nums[left], mp.get(nums[left]) - 1);

                if (mp.get(nums[left]) == 0){
                    mp.remove(nums[left]);
                }
                left++;
            }

            count += (right - left + 1);

            right++;
        }
        return count;
    }

    public int totalWaviness(int num1, int num2) {
        int totalWaviness = 0;

        int diff = num2 - num1;

        while (diff >= 0){
            totalWaviness += calculateWaviness(String.valueOf(num1));
            num1 += 1;
            diff--;
        }

        return totalWaviness;

    }

    public int calculateWaviness(String digit){

        int count = 0;

        for (int i = 0; i < digit.length() - 2; i++){
            int firstDigit = digit.charAt(i) - '0';
            int middleDigit = digit.charAt(i+1) - '0';
            int lastDigit = digit.charAt(i+2) - '0';

            if (firstDigit < middleDigit && middleDigit > lastDigit){
                count += 1;
            } else if (firstDigit > middleDigit && lastDigit > middleDigit){
                count += 1;
            }
        }
        return count;

    }

    public int longestSubarray(int[] nums, int k) {
        int n = nums.length;

        // To store the maximum length of the subarray
        int maxLen = 0;

        // Pointers to mark the start and end of window
        int left = 0, right = 0;

        // To store the sum of elements in the window
        int sum = nums[0];

        // Traverse all the elements
        while (right < n) {

            // If the sum exceeds K, shrink the window
            while (left <= right && sum > k) {
                sum -= nums[left];
                left++;
            }

            // Store the maximum length
            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }

            right++;
            if (right < n) sum += nums[right];
        }

        return maxLen;
    }



}
