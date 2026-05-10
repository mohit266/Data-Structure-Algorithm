package com.dsa.SlidingWindowAndTwoPointer;

public class NumberOfSubStringContainingAllThreeCharacters {

    public static void main(String[] args) {
        String s = "ccabcc";
        System.out.println(numberOfSubstrings(s));
    }


    public static int numberOfSubstringsOptimal(String s) {

        int[] lastSeen = {-1, -1, -1};

        int count = 0;

        for (int i = 0; i < s.length(); ++i) {

            lastSeen[s.charAt(i) - 'a'] = i;

            if (lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1) {
                count += 1 + Math.min(Math.min(lastSeen[0], lastSeen[1]), lastSeen[2]);
            }
        }
        return count;
    }

    public static int numberOfSubstrings(String s) {

        int left = 0;
        int right = 0;

        int[] hash = new int[256];

        hash['a']++;
        hash['b']++;
        hash['c']++;

        int count = 0;

        int ans = 0;

        while (right < s.length()){

            char c = s.charAt(right);

            if (hash[c] > 0){
                count++;
            }
            hash[c]--;

            while (count == 3){

                ans += s.length() - right;

                hash[s.charAt(left)]++;

                if (hash[s.charAt(left)] > 0) {
                    count--;
                }
                left++;
            }
            right++;

        }
        return ans;
    }

}
