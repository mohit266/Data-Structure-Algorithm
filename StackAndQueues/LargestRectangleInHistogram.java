package com.dsa.StackAndQueues;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};

        System.out.println(largestRectangleArea(heights));

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
