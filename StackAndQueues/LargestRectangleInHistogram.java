package com.dsa.StackAndQueues;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};

        System.out.println(largestRectangleAreaa(heights));

    }

    public static int largestRectangleAreaa(int[] heights) {

        int[] nse = NSE(heights);
        int[] pse = PSE(heights);

        int largestRectArea = 0;

        for (int i = 0; i < heights.length; i++){
            largestRectArea = Math.max(largestRectArea, heights[i] * (nse[i] - pse[i] - 1));
        }

        return largestRectArea;
    }

    public static int[] NSE(int[] arr){
        Stack<Integer> st = new Stack<>();
        int n = arr.length;

        int[] result = new int[n];

        for (int i = n-1; i >= 0; i--){

            while (!st.isEmpty() && arr[i] <= arr[st.peek()]){
                st.pop();
            }

            if(st.isEmpty()){
                result[i] = n;
            } else {
                result[i] = st.peek();
            }
            st.push(i);
        }
        return result;

    }

    private static int[] PSE(int[] arr) {
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

    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> st =new Stack<>();
        int maxArea = 0;
        int nse;
        int pse;
        int previousEle;

        for (int i = 0; i < heights.length; i++){

            while (!st.isEmpty() && heights[st.peek()] > heights[i]){
                previousEle = st.pop();
                nse = i;
                pse = st.isEmpty() ? -1: st.peek();
                maxArea = Math.max(maxArea, heights[previousEle] * (nse - pse - 1));

            }
            st.push(i);
        }

        while (!st.isEmpty()){
            nse = heights.length;
            previousEle = st.pop();
            pse = st.isEmpty() ? -1: st.peek();
            maxArea = Math.max(maxArea, heights[previousEle] * (nse - pse - 1));
        }
        return maxArea;
    }
}
