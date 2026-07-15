package com.dsa.DailyChallenges;

public class GCDOfOddEvenSums {

    public static void main(String[] args) {
        GCDOfOddEvenSums gc = new GCDOfOddEvenSums();
        int n = 4;

        System.out.println(gc.gcdOptimal(4));
    }

    public int gcdOfOddEvenSums(int n) {
        int even  = 2;
        int odd = 1;

        int sumOfEven = 2;
        int sumOfOdd = 1;

        while(n > 1) {
            even =  even + 2;
            sumOfEven = sumOfEven + even;

            odd = odd + 2;
            sumOfOdd = sumOfOdd + odd;

            n--;
        }

        return GCD(sumOfEven, sumOfOdd);
    }

    public int gcdOptimal(int n){
        int sumOdd = n * n;
        int sumEven = n * (n + 1);

        return GCD(sumEven, sumOdd);

    }

    public int GCD(int n1, int n2){

        while (n1 > 0 && n2 > 0){
            if (n1 > n2){
                n1 = n1%n2;
            } else if (n2 > n1) {
                n2 = n2%n1;
            }
        }
        if (n1 == 0) return n2;
        return n1;
    }

}
