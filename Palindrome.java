package com.dsaAtoZ.BasicMath;
class Palindrome {

    // https://leetcode.com/problems/palindrome-number/
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }

    public static boolean isPalindrome(int x) {
        int originalNum = x;
        int ld;
        int revNum = 0;
        while(x>0){
            ld = x%10;
            if (revNum > Integer.MAX_VALUE / 10 ){
                return false;
            }
            revNum = (revNum * 10) + ld;
            x = x/10;
        }

        return originalNum == revNum;
    }
}
