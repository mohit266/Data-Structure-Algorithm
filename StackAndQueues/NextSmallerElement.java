package com.dsa.StackAndQueues;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElement {
    public static void main(String[] args) {
        int[] arr = {4, 8, 5, 2, 25};
        System.out.println(Arrays.toString(nextSmallerElements(arr)));
        // Output: [2, 5, 2, -1, -1]
    }

    public static int[] nextSmallerElements(int[] arr) {
        Stack<Integer> st = new Stack<>();

        int[] res = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--){

            while (!st.isEmpty() && arr[i] <= st.peek()){
                st.pop();
            }

            if (st.isEmpty()){
                res[i] = -1;
            } else {
                res[i] = st.peek();
            }

            st.push(arr[i]);

        }
        return res;
    }
}
