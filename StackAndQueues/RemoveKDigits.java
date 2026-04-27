package com.dsa.StackAndQueues;

import java.util.Stack;

public class RemoveKDigits {
    public static void main(String[] args) {
        String num = "1002991";
        int k = 3;

        // output = 1219
        System.out.println(removeKdigits(num, k));

    }

    public static String removeKdigits(String num, int k) {

        if (num.length() == k) return "0";

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < num.length(); i++){

            int val = Integer.parseInt(String.valueOf(num.charAt(i)));

            while (!st.isEmpty() && (st.peek() > val) && k > 0){
                st.pop();
                k--;
            }

            st.push(val);
        }

        while (k > 0) {
            st.pop();
            k--;
        }

        if (st.isEmpty()) return "0";

        String res = "";
        for (int i : st){
            res = res + i;
        }

        return res.replaceFirst("^0+(?!$)", "");
    }
}
