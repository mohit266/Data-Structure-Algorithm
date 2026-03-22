package com.dsa.BasicMath;

// GCD (Greatest common divisor) / HCF (Highest common factor)
public class GCD {
    public static void main(String[] args) {
        System.out.println(gcdNum(52,10));
        System.out.println(findGcd(52,10));
    }


    public static int gcdNum(int n1, int n2){
        int smallerNumber = Math.min(n1, n2);

        for(int i = smallerNumber; i>=1; i--){
            if (n1%i == 0 && n2%i==0){
                return i;
            }
        }
        return 1;
    }

    //  Euclidean Algorithm
    public static int findGcd(int n1, int n2) {
        while(n1 > 0 && n2 > 0){
            if (n1>n2){
                n1 = n1%n2;
            } else {
                n2 = n2%n1;
            }
        }
        if (n1 == 0) return n2;
        return n1;
    }
}
