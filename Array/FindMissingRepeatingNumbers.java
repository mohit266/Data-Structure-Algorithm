package com.dsa.Array;

import java.util.Arrays;

public class FindMissingRepeatingNumbers {

    public static void main(String[] args) {
        int[] arr = {3, 5, 4, 1, 1};
        System.out.println(Arrays.toString(getMissingAndRepeatingNumber(arr)));
        System.out.println(Arrays.toString(optimalSol(arr)));
    }


    // Time Complexity - O(n) and Space complexity - O(1).

    private static int[] optimalSol(int[] nums){
        int n = nums.length;

        long s1 = 0;
        long s1n = ((long) n * (n + 1))/2;

        long s2 = 0;
        long s2n = (n * (n+1) * ((2L * n)+1))/6;

        for (int num : nums){
            s1 = s1 + num;
            s2 = s2 + (long) num * num;
        }

        // x - y
        long val1 = s1 - s1n;
        // x+ y
        long val2 = (s2 - s2n) / val1;

        /*
         x - y = val1;
         x + y = val2;
         _____________
         2x = val1 + val2;
         x = (val1 + val2)/2;

         y = x - val1;
         */

        long x = (val1+val2) / 2;
        long y = x - val1;

        return new int[] {(int) x, (int) y};
    }



    // Time Complexity = O(2n) and its taking extra space i.e., O(n) --> space complexity.
    private static int[] getMissingAndRepeatingNumber(int[] nums){
        int[] arr = new int[nums.length+1];

        for (int num : nums){
            arr[num] ++;
        }

        int repeatingNum = -1;
        int missingNum = -1;
        for (int i =1; i< arr.length; i++){
            if (arr[i] > 1){
                repeatingNum = i;
            } else if (arr[i] == 0) {
                missingNum = i;
            }

            if (repeatingNum != -1 && missingNum != -1){
                break;
            }
        }
        return new int[] {repeatingNum, missingNum};
    }

}
