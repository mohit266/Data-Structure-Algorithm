package com.dsaAtoZ.Array;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfArray {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 3, 3, 4, 5, 6};
        int[] arr2 = {2, 3, 3, 5, 6, 7};

        System.out.println("Intersection of two array is :: " +getIntersectionOfTwoArray(arr1, arr2));

    }

    // Time complexity is O(n1+n2)
    // Space complexity is O(1)
    public static List<Integer> getIntersectionOfTwoArray(int[] arr1, int[] arr2){
        int n1 = arr1.length;
        int n2 = arr2.length;

        int i = 0;
        int j = 0;

        List<Integer>intersectionList = new ArrayList<>();

        while (i < n1 && j < n2){
            if (arr1[i] < arr2[j]){
                i++;
            } else if (arr2[j] < arr1[i]) {
                j++;
            } else {
                if (intersectionList.isEmpty() || intersectionList.get(intersectionList.size()-1) != arr1[i]){
                    intersectionList.add(arr1[i]);
                }
                i++;
                j++;
            }
        }

        return intersectionList;
    }
}
