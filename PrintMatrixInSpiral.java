package com.dsaAtoZ.Array;

import java.util.ArrayList;
import java.util.List;

public class PrintMatrixInSpiral {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiralList = new ArrayList<>();

        int n = matrix.length;
        int m = matrix[0].length;

        int top = 0;
        int left = 0;
        int right = m-1;
        int bottom = n-1;

        /* int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        }; */

        while (top <= bottom && left <= right){
            for (int i = left; i<= right; i++){
                spiralList.add(matrix[top][i]);
            }
            top++;

            for(int i = top; i<=bottom; i++){
                spiralList.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom){
                for (int i = right; i>= left; i--){
                    spiralList.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if (left <= right){
                for (int i = bottom; i>= top; i--){
                    spiralList.add(matrix[i][left]);
                }
                left++;
            }
        }
        return spiralList;
    }
}
