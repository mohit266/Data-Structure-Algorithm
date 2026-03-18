package com.dsaAtoZ.Array;

public class MissingNumberInArray {

    public static void main(String[] args) {
        int[] arr = {0, 2, 3, 1, 4};
        System.out.println("Missing Number is :: " +getMissingNumber(arr));
    }

    public static int getMissingNumber(int[] arr){
        long sum = 0;
        long n = arr.length;

        for (int j : arr) {
            sum += j;
        }

        // The sum of the first n natural numbers is given by the formula (n * (n + 1)) / 2.
        long expectedSum = (n * (n +1))/2;

        return (int) (expectedSum - sum);
    }


}
