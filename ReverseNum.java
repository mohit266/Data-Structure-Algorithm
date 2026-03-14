package com.dsaAtoZ.BasicMath;

public class ReverseNum {

    // https://leetcode.com/problems/reverse-integer/
    public static void main(String[] args) {
        System.out.println(reverse(-321));
        System.out.println(reverse(1534236469));
    }

    public static int reverse(int x) {
        int reverseNumber = 0;

        while(Math.abs(x) > 0){
            int lastDigit = x%10;

            // To handle -2³¹ ≤ x ≤ 2³¹ - 1 constraint.
            if (reverseNumber > Integer.MAX_VALUE / 10 || reverseNumber < Integer.MIN_VALUE / 10) {
                return 0;
            }
            reverseNumber = reverseNumber*10 + lastDigit;
            x = x/10;
        }
        return reverseNumber;
    }
}


