package com.dsa.PatternWise.Stack;

import java.util.Stack;

// 1209. Remove All Adjacent Duplicates in String II
public class RemoveAllAdjacentDuplicatesInStringII {

    public static void main(String[] args) {

        RemoveAllAdjacentDuplicatesInStringII r = new RemoveAllAdjacentDuplicatesInStringII();

        String s = "yfttttfbbbbnnnnffbgffffgbbbbgssssgthyyyy";
        int k = 4;

        System.out.println(r.removeDuplicates(s, k));
    }

    public String removeDuplicates(String s, int k) {

        Stack<Object[]> st = new Stack<>();

        for (char c : s.toCharArray()){

            if (!st.isEmpty() && (char) st.peek()[0] == c && (int) st.peek()[1] == k - 1){
                while (!st.isEmpty() && (char) st.peek()[0] == c) {
                    st.pop();
                }
                continue;
            }

            if (st.isEmpty()) {
                st.push(new Object[] {c, 1});
                continue;
            }

            Object[] arr = st.peek();

            if ((char) arr[0] == c){
                st.push(new Object[] {c, (int) arr[1] + 1});
            } else {
                st.push(new Object[] {c, 1});
            }

        }

        StringBuilder str = new StringBuilder(st.size());

        while (!st.isEmpty()){
            str.append(st.pop()[0]);
        }

        return (str.reverse()).toString();
    }

}
