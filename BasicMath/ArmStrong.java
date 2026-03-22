package com.dsa.BasicMath;

class ArmStrong {

    public static void main(String[] args) {
        System.out.println(isArmstrong(153));
    }

    public static boolean isArmstrong(int n) {
        int sum = 0;
        int originalNum = n;
        while(n>0){
            int ld = n%10;
            sum = sum + (int) Math.pow(ld,3);
            n = n/10;
        }

        return sum == originalNum;
    }
}