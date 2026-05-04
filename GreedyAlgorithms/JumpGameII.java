package com.dsa.GreedyAlgorithms;

public class JumpGameII {
    public static void main(String[] args) {
        JumpGameII jumpGameII = new JumpGameII();
        int[] nums = {7,0,9,6,9,6,1,2,9,0,1,2,9,0,3};

        System.out.println(jumpGameII.jump(nums));
    }

    public int jump(int[] nums) {
        int jumps = 0;
        int currEnd = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            if (i == currEnd) {
                jumps++;
                currEnd = farthest;
            }
        }

        return jumps;
    }
}
