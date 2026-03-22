package com.dsa.Array;

public class SingleNumber {

    public static void main(String[] args) {
        int[] arr = {4, 1, 2, 1, 2};

        System.out.println(getSingleNum(arr));

    }

    public static int getSingleNum(int[] arr){
        int xor = 0;

        for (int i: arr){
            xor = xor ^ i;
        }
        return xor;
    }
}
