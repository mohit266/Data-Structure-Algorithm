package com.dsa.PatternWise.Stack;

import java.util.Arrays;
import java.util.Stack;

// 503. Next Greater Element II
public class NextGreaterElementII {

    public static void main(String[] args) {
        NextGreaterElementII n = new NextGreaterElementII();
        int[] nums = {31,-41,59,26,-53,58,97,-93,-23,84};

        System.out.println(Arrays.toString(n.nextGreaterElements(nums)));
    }

    public int[] nextGreaterElements(int[] nums) {

        Stack<Integer> st = new Stack<>();

        int n = nums.length;

        int[] res = new int[n];

        for (int i = n * 2 - 1; i >= 0; i--){
            while (!st.isEmpty() && st.peek() <= nums[i%n]){
                st.pop();
            }

            int nextGreater = -1;

            if (!st.isEmpty()){
                nextGreater = st.peek();
            }

            st.push(nums[i%n]);

            res[i%n] = nextGreater;
        }
        return res;
    }

}
