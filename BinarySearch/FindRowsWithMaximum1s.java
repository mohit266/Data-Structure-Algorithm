package com.dsa.BinarySearch;

public class FindRowsWithMaximum1s {
    public static void main(String[] args) {
        int[][] mat = { {1, 1, 1}, {0, 0, 1}, {0, 0, 0} };

        System.out.println(rowWithMax1s(mat));
    }

    public static int rowWithMax1s(int[][] mat) {
        int count = 0;
        int index = -1;

        for (int i = 0; i < mat.length; i++){
             int getCount = getCountOf1s(mat[i]);

             if (getCount > count){
                 count = getCount;
                 index = i;
             }
        }
        return index;
    }

    public static int getCountOf1s(int[] nums){
        int low = 0;
        int high = nums.length-1;
        int target = 1;
        int ans = nums.length;

        while (low <= high){
            int mid = (low+high)/2;

            if (nums[mid] < target){
                low = mid + 1;
            } else {
                ans = mid;
                high = mid - 1;
            }
        }
        return nums.length - ans;
    }

}
