package com.dsaAtoZ.BasicMath;

class CountNumber {

    public static void main(String[] args) {
        System.out.println(countDigit(10));
        System.out.println(countDigits(524));
        System.out.println(countDigitUsingLog(2214));
    }

    public static int countDigit(int n) {
        if (n >=0 && n <= 5000){
            return String.valueOf(n).length();
        } else {
            return -1;
        }
    }

    public static int countDigits(int n) {
        if (n < 0 || n > 5000) return -1;

        int count = 0;

        do {
            n = n/10;
            count ++;
        } while (n!=0);

        return count;
    }

    // Another way
    public static int countDigitUsingLog(int n) {
        if (n < 0 || n > 5000) return -1;
        return (int) Math.log10(n) + 1;
    }
}