package com.dsa.DailyChallenges;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class SeparateTheDigitsInAnArray {

    public static void main(String[] args) {
        SeparateTheDigitsInAnArray s = new SeparateTheDigitsInAnArray();

        int[] nums = {13,25,83,77};
        System.out.println(Arrays.toString(s.separateDigits(nums)));
    }

    public int[] separateDigits(int[] nums) {
        List<Integer> ls = new ArrayList<>();

        for (int n : nums){
            separate(n, ls);
        }

        int[] result = new int[ls.size()];

        int i = 0;

        while (i < ls.size()){
            result[i] = ls.get(i);
            i++;
        }

        return result;
    }

    public void separate(int n, List<Integer> ls){
        int index = ls.size();
        while (n > 0) {
            ls.add(index, n % 10);
            n /= 10;
        }
    }
}
