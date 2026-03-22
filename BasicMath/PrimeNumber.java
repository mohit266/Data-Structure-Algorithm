package com.dsa.BasicMath;

public class PrimeNumber {
    public static void main(String[] args) {
        System.out.println(isPrime(17));
        System.out.println(isPrimeSecondApproach(17));
    }


    // Time complexity of this method is O(N)
    public static boolean isPrime(int n) {
        int count = 0;
        for (int i=1; i<=n; i++){
            if (n%i == 0){
                count++;
            }
        }
        return count == 2;
    }

    // Time complexity is O(Sqrt(n))
    public static boolean isPrimeSecondApproach(int n) {
        int count = 0;
        for (int i=1; i*i<=n; i++){
            if (n%i == 0){
                count++;
                if (n/i != i){
                    count++;
                }
            }
        }
        return count == 2;
    }
}
