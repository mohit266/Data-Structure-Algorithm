package com.dsa.PatternWise.PrefixSum;

import java.util.Arrays;

public class XORQueriesOfASubArray {

    public static void main(String[] args) {
        XORQueriesOfASubArray x = new XORQueriesOfASubArray();
        int[] arr = {1,3,4,8};
        int[][] queries = {{0,1},{1,2},{0,3},{3,3}};

        System.out.println(Arrays.toString(x.xorQueries(arr, queries)));
    }

    public int[] xorQueries(int[] arr, int[][] queries) {
        int len = arr.length;

        int[] result = new int[queries.length];

        for (int i = 1; i < len; i++){
            arr[i] = arr[i-1] ^ arr[i];
        }

        int j = 0;
        for (int[] query : queries){
            if (query[0] == 0){
                result[j] = arr[query[1]];
            } else {
                result[j] = arr[query[1]] ^ arr[query[0] - 1];
            }
            j++;
        }
        return result;
    }

}
