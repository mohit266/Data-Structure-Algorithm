package com.dsa.DailyChallenges;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// 6. Zigzag Conversion
public class ZigZagConversion {

    public static void main(String[] args) {
        ZigZagConversion zig = new ZigZagConversion();

        String s = "PAYPALISHIRING";
        int numRows = 3;

        System.out.println(zig.convertOptimal(s, numRows));
    }


    public String convertOptimal(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        int row = 0;
        boolean down = true;

        for (char ch : s.toCharArray()) {

            rows.get(row).append(ch);

            if (row == 0) {
                down = true;
            } else if (row == numRows - 1) {
                down = false;
            }

            if (down) {
                row++;
            } else {
                row--;
            }
        }

        StringBuilder result = new StringBuilder();

        for (StringBuilder sb : rows) {
            result.append(sb);
        }

        return result.toString();
    }

    public String convert(String s, int numRows) {

        boolean increasingOrder = true;
        int num = 1;

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        for (int i = 0; i < s.length(); i++){

            q.offer(new int[] {num, i});
            if (increasingOrder){
                num++;
            } else {
                num--;
            }

            if (num == numRows || num == 1){
                increasingOrder = !increasingOrder;
            }
        }

        StringBuilder res = new StringBuilder();

        while (!q.isEmpty()){
            int[] cell = q.poll();
            res.append(s.charAt(cell[1]));
        }

        return res.toString();
    }

}
