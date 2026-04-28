package com.dsa.StackAndQueues;

import java.util.Stack;

public class SumOfSubArrayMinimum {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 5};
        System.out.println(sumSubArrayMin(arr));
    }

    public static int sumSubArrayMin(int[] arr) {
        int n = arr.length;

        int[] nse = findNSE(arr);
        int[] psee = findPSEE(arr);

        int mod = (int) 1e9 + 7;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int left = i - psee[i];

            int right = nse[i] - i;

            long freq = (long) left * right;

            int val = (int)((freq * arr[i]) % mod);

            sum = (sum + val) % mod;
        }
        return sum;
    }

    private static int[] findNSE(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            ans[i] = !st.isEmpty() ? st.peek() : n;

            st.push(i);
        }

        return ans;
    }

    private static int[] findPSEE(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            ans[i] = !st.isEmpty() ? st.peek() : -1;

            st.push(i);
        }

        return ans;
    }

}
