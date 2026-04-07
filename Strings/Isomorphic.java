package com.dsa.Strings;

public class Isomorphic {
    public static void main(String[] args) {

         String str1 = "badc";
         String str2 = "baba";

        System.out.println(isomorphicString(str1, str2));
    }

    public static boolean isomorphicString(String s, String t) {
        int[] m1 = new int[256], m2 = new int[256];

        int n = s.length();
        for (int i = 0; i < n; ++i) {
            if (m1[s.charAt(i)] != m2[t.charAt(i)]) return false;

            m1[s.charAt(i)] = i + 1;
            m2[t.charAt(i)] = i + 1;
        }
        return true;
    }
}
