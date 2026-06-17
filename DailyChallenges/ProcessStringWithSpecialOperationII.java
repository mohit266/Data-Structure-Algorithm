package com.dsa.DailyChallenges;

public class ProcessStringWithSpecialOperationII {
    public static void main(String[] args) {
        ProcessStringWithSpecialOperationII p = new ProcessStringWithSpecialOperationII();

        System.out.println(p.processStr("cd%#*#",3));
    }

    public char processStr(String s, long k) {
        int n = s.length();

        long len= 0;
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);

            if (ch == '#'){
                len = len * 2;
            } else if (ch == '%'){
                continue;
            } else if (ch == '*'){
                if (len > 0){
                    len--;
                }
            } else {
                len++;
            }
        }

        if (k >= len){
            return '.';
        }

        for (int i = n-1; i >= 0; i--){
            char ch = s.charAt(i);

            if (ch == '#'){
                len = len/2;
                if (k >= len){
                    k = k - len;
                }
            } else if (ch == '%'){
                k = len - k - 1;
            } else if (ch == '*') {
                len++;
            } else {
                len--;
                if (len == k) return ch;
            }
        }

        return '.';
    }
}
