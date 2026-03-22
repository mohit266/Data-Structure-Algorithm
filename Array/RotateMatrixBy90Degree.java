package com.dsa.Array;

import java.util.Arrays;

public class RotateMatrixBy90Degree {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        rotateMatrix(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    public static void rotateMatrix(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;

        // Step 1 : Transpose the matrix --> Means row becomes columns and vice versa.
        for (int i = 0 ; i < n - 1; i++){
            for (int j = i + 1; j < m; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i<n; i++){
            int left = 0;
            int right = n-1;

            while (left < right){
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }
}
