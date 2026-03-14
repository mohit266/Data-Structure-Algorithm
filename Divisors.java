package com.dsaAtoZ.BasicMath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Divisors {

    public static void main(String[] args) {
        System.out.println(divisors(36));
        System.out.println(divisorsSecondApproach(36));
    }

    // Time complexity of this method is O(N)
    public static List<Integer> divisors(int n) {
        List<Integer> divisorsLst = new ArrayList<>();
        for(int i=1; i <=n ; i++){
            if (n%i == 0){
                divisorsLst.add(i);
            }
        }
        return divisorsLst;
    }

    // Time complexity is O(Sqrt(n))
    public static List<Integer> divisorsSecondApproach(int n) {
        List<Integer> divisorsLst = new ArrayList<>();
        for(int i=1; i*i <=n ; i++){
            if (n%i == 0){
                divisorsLst.add(i);

                if(n/i != i){
                    divisorsLst.add(n/i);
                }
            }
        }

        // Time Complexity O(n log(n))
        Collections.sort(divisorsLst);
        return divisorsLst;
    }
}