package com.dsa.StackAndQueues;

import java.util.Stack;

public class MaximumRectangles {
    public static void main(String[] args) {
        int [][] matrix = {{1, 0, 1, 0, 0},
                           {1, 0, 1, 1, 1},
                           {1, 1, 1, 1, 1},
                           {1, 0, 0, 1, 0}
        };
        // 3 1 3 2 2

        System.out.println(maximalAreaOfSubMatrixOfAll1(matrix));
    }

    public static int maximalAreaOfSubMatrixOfAll1(int[][] matrix) {
        if (matrix.length == 0) return 0;

        int m = matrix[0].length;

        int[] height = new int[m];

        int maxArea = 0;

        for (int[] row : matrix) {
            for (int i = 0; i < m; i++) {
                if (row[i] == 1) height[i]++;
                else height[i] = 0;
            }
            maxArea = Math.max(maxArea, getMaxArea(height));
        }

        return maxArea;
    }

    public static int getMaxArea(int[] heights){
        Stack<Integer> st = new Stack<>();
        int area = 0;
        int val;
        int pse;
        int nse;

        for (int i = 0; i < heights.length; i++){

            while (!st.isEmpty() && heights[st.peek()] > heights[i]){
                val = st.pop();
                pse = st.isEmpty() ? -1 : st.peek();
                nse = i;
                area = Math.max(area, (nse - pse - 1) * heights[val]);
            }
            st.push(i);
        }

        while (!st.isEmpty()){
            nse = heights.length;
            val = st.pop();
            pse = st.isEmpty() ? -1: st.peek();
            area = Math.max(area, heights[val] * (nse - pse - 1));
        }

        return area;
    }
}


