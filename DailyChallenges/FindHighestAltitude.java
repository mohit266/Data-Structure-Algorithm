package com.dsa.DailyChallenges;

public class FindHighestAltitude {
    public static void main(String[] args) {
        FindHighestAltitude f = new FindHighestAltitude();
        int [] gain = {-5,1,5,0,-7};

        System.out.println(f.largestAltitude(gain));
    }

    public int largestAltitude(int[] gain) {
        int maxAltitude = 0;

        int sum = 0;
        for (int alt : gain){
            sum = sum + alt;
            maxAltitude = Math.max(maxAltitude, sum);
        }

        return maxAltitude;
    }
}
