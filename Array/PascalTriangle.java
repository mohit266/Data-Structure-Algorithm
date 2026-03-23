package com.dsa.Array;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        int numRows = 6;
        System.out.println(generate(numRows));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ls = new ArrayList<>();
        for (int i = 1; i <= numRows; i++){
            ls.add(generatePascalRow(i));
        }
        return ls;
    }


    // Method to generate nth row.
    private static List<Integer> generatePascalRow(int n){
        List<Integer> ls = new ArrayList<>();
        ls.add(1);
        int res = 1;
        for (int i = 1; i < n; i++){
            res = res * (n-i);
            res = res / (i);
            ls.add(res);
        }
        return ls;
    }
}
