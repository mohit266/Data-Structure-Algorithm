package com.dsa.DailyChallenges;

public class Unique3DigitEvenNumber {

    public static void main(String[] args) {
        Unique3DigitEvenNumber u = new Unique3DigitEvenNumber();
        int[] nums = {1, 2, 3, 4};

        System.out.println(u.totalNumbers(nums));
    }


    public int totalNumbers(int[] digits) {
        int ans = 0;
        int n = digits.length;
        boolean[] hash = new boolean[1000];

        for (int i = 0; i < n; i++){
            if (digits[i] == 0){
                continue;
            }
            for (int j = 0; j < n; j++){
                if (i == j){
                    continue;
                }
                for (int k = 0; k < n; k++){
                    if (k == j || k == i){
                        continue;
                    }

                    if (digits[k] % 2 != 0){
                        continue;
                    }

                    int val = digits[i] * 100 + digits[j] * 10 + digits[k];
                    if (!hash[val]) {
                        hash[val] = true;
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

}
