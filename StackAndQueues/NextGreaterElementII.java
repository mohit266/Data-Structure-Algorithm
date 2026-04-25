package com.dsa.StackAndQueues;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {
    public static void main(String[] args) {

        int[] arr = {3, 10, 4, 2, 1, 2, 6, 1, 7, 2, 9};
        System.out.println(Arrays.toString(nextGreaterElements(arr)));


    }

    public static int[] nextGreaterElements(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int [] res = new int[arr.length];

        for (int i = (2 * arr.length) - 1; i >= 0; i--){
            while (!st.isEmpty() && st.peek() <= arr[i % (arr.length)]){
                st.pop();
            }

            if (i < (arr.length)){
                if (st.isEmpty()) {
                    res[i] = -1;
                } else {
                    res[i] = st.peek();
                }
            }
            st.push(arr[i % (arr.length)]);
        }

        return res;
    }
}
