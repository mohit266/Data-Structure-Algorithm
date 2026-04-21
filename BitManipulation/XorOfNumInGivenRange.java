package com.dsa.BitManipulation;

public class XorOfNumInGivenRange {
    public static void main(String[] args) {
        System.out.println(findRangeXOR(3, 5));
    }

    // TC - O(1)
    public static int findRangeXOR(int l, int r) {
        return getXorOfNum(l-1) ^ getXorOfNum(r);
    }

    public static int getXorOfNum(int n){
        if (n % 4 == 1){
            return 1;
        } else if (n % 4 == 2){
            return n+1;
        } else if (n % 4 == 3){
            return 0;
        } else {
            return n;
        }
    }

    // Brute force TC - O(N)
    public int getRangeXOR(int l, int r) {
        int res = 0;
        for (int i= l; i <= r; i++){
            res = res ^ i;
        }
        return res;
    }
}
