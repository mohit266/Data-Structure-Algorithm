package com.dsa.StackAndQueues;

import java.util.Arrays;
import java.util.Stack;

public class StockSpanProblem {

    public static void main(String[] args) {

        int[] arr = {30, 20, 25, 28, 27, 29, 35, 40};
        int n = 8;

        System.out.println(Arrays.toString(stockSpan(arr, n)));
    }
    public static int[] stockSpan(int[] arr, int n) {

        int[] res = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++){
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]){
                st.pop();
            }

            if (st.isEmpty()){
                res[i] = i + 1;
            } else {
                res[i] = i - st.peek();
            }

            st.push(i);
        }
        return res;
    }
}
