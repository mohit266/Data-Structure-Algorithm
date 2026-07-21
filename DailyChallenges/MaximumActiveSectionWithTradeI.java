package com.dsa.DailyChallenges;

public class MaximumActiveSectionWithTradeI {

    public static void main(String[] args) {

        MaximumActiveSectionWithTradeI m = new MaximumActiveSectionWithTradeI();

        String s = "1000100";
        System.out.println(m.maxActiveSectionsAfterTrade(s));
    }

    public int maxActiveSectionsAfterTrade(String s) {

        int ones = 0;
        int prev = -1;
        int maxSum = 0;

        int i = 0;
        while(i < s.length()){
            if (s.charAt(i) == '1'){
                ones++;
                i++;
            } else {
                int curr = 0;

                while (i < s.length() && s.charAt(i) == '0' ){
                    curr++;
                    i++;
                }

                if (prev > 0){
                    maxSum = Math.max(maxSum, prev + curr);
                }
                prev = curr;
            }
        }
        return ones + maxSum;
    }

}
