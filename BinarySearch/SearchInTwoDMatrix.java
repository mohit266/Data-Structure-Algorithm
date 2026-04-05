package com.dsa.BinarySearch;

public class SearchInTwoDMatrix {
    public static void main(String[] args) {
        int[][] mat = {{1,3,5,7}, {10,11,16,20}, {23,30,34,60}};
        int target = 13;

        System.out.println(searchMatrix(mat, target));
    }

    // Optimal Approach
    public boolean searchMat(int[][] matrix, int target) {
        // Get the number of rows
        int n = matrix.length;

        // Get the number of columns
        int m = matrix[0].length;

        int low = 0, high = n * m - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            // Map 1D index to 2D coordinates
            int row = mid / m;
            int col = mid % m;

            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    public static boolean searchMatrix(int[][] mat, int target) {
        int low = 0;
        int high = mat.length-1;

        int colSize = mat[0].length-1;
        int index = -1;

        while(low <= high){
            int mid = (low+high)/2;

            if(mat[mid][0] <= target && mat[mid][colSize] >= target){
                index = mid;
                break;
            } else if (mat[mid][0] < target && mat[mid][colSize] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (index == -1) {
            return false;
        }

        low = 0;
        high = mat[index].length-1;

        while (low <= high){
            int mid = (low + high)/2;

            if (mat[index][mid] == target){
                return true;
            } else if (mat[index][mid] < target){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }


}
