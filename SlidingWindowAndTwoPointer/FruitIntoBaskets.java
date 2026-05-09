package com.dsa.SlidingWindowAndTwoPointer;

import java.util.HashMap;

public class FruitIntoBaskets {
    public static void main(String[] args) {
        int[] fruits = {1, 2, 3, 2, 2};

        System.out.println(totalFruits(fruits));
    }

    public static int totalFruits(int[] fruits) {
        HashMap<Integer, Integer> mp = new HashMap<>();

        int left = 0;
        int right = 0;

        int n = fruits.length;
        int maxLen = 0;

        while (right < n){

            mp.put(fruits[right],
                    mp.getOrDefault(fruits[right], 0) + 1);

            while (mp.size() > 2) {

                mp.put(fruits[left], mp.get(fruits[left]) - 1);

                if (mp.get(fruits[left]) == 0) {
                    mp.remove(fruits[left]);
                }

                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }

    public int totalFruitsOptimalOne(int[] fruits) {
        HashMap<Integer, Integer> mp = new HashMap<>();

        int left = 0;
        int right = 0;

        int n = fruits.length;
        int maxLen = 0;

        while (right < n){

            mp.put(fruits[right],
                    mp.getOrDefault(fruits[right], 0) + 1);

            if (mp.size() > 2) {

                mp.put(fruits[left], mp.get(fruits[left]) - 1);

                if (mp.get(fruits[left]) == 0) {
                    mp.remove(fruits[left]);
                }

                left++;
            }

            if (mp.size() <= 2){
                maxLen = Math.max(maxLen, right - left + 1);
            }
            right++;
        }
        return maxLen;
    }
}
