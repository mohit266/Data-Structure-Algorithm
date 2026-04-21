package com.dsa.BitManipulation;

public class DivideTwoNum {
    public static void main(String[] args) {
        System.out.println(divide(42, 5));
    }

    public static int divide(int dividend, int divisor) {

        if (dividend == divisor) return 1;
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if (divisor == 1) return dividend;

        boolean isPositive = true;

        if (dividend >= 0 && divisor < 0)
            isPositive = false;
        else if (dividend < 0 && divisor > 0)
            isPositive = false;

        long n = dividend;
        long d = divisor;

        n = Math.abs(n);
        d = Math.abs(d);

        long ans = 0, cnt;

        while (n >= d){
            cnt = 0;
            while (n >= (d << (cnt+1))){
                cnt++;
            }
            ans += (1L << cnt);
            n = n - (d * (1L << cnt));
        }


        if (ans > Integer.MAX_VALUE && isPositive)
            return Integer.MAX_VALUE;

        if (ans > Integer.MAX_VALUE)
            return Integer.MIN_VALUE;

        return isPositive ? (int) ans : (int)(-1 * ans);
    }
}
