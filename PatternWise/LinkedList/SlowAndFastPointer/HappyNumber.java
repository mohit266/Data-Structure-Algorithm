package com.dsa.PatternWise.LinkedList.SlowAndFastPointer;

// 202. Happy Number
public class HappyNumber {

    public static void main(String[] args) {
        HappyNumber h = new HappyNumber();

        int n = 19;
        System.out.println(h.isHappy(n));
    }

    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        while (fast != 1){
            slow = getSumOfN(slow);
            fast = getSumOfN(fast);
            fast = getSumOfN(fast);

            if (slow == fast && fast != 1){
                return false;
            }
        }
        return true;
    }

    public int getSumOfN(int n){
        int ans = 0;
        while (n > 0){
            int rem = n % 10;
            ans = ans + (rem * rem);
            n = n / 10;
        }
        return ans;
    }
}
