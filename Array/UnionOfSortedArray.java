package com.dsa.Array;

import java.util.ArrayList;
import java.util.List;

public class UnionOfSortedArray {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 3, 3, 4, 5, 6};
        int[] arr2 = {2, 3, 3, 5, 6, 7};

        System.out.println("Union of two array is :: "+getUnionOfTwoArray(arr1, arr2));
    }

    public static List<Integer> getUnionOfTwoArray(int[] arr1, int[] arr2){
        int n1 = arr1.length;
        int n2 = arr2.length;

        int i = 0;
        int j = 0;

        List<Integer> unionList = new ArrayList<>();

        while (i < n1 && j < n2){
            if (arr1[i] <= arr2[j]){
                if (unionList.isEmpty() || unionList.get(unionList.size()-1) != arr1[i]){
                    unionList.add(arr1[i]);
                }
                i++;
            } else {
                if (unionList.isEmpty() || unionList.get(unionList.size()-1) != arr2[j]){
                    unionList.add(arr2[j]);
                }
                j++;
            }
        }

        while (i < n1){
            if (unionList.isEmpty() || unionList.get(unionList.size()-1) != arr1[i]){
                unionList.add(arr1[i]);
            }
            i++;
        }

        while (j < n2){
            if (unionList.isEmpty() || unionList.get(unionList.size()-1) != arr2[j]){
                unionList.add(arr2[j]);
            }
            j++;
        }
        return unionList;
    }
}
