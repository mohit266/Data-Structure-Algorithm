package com.dsa.StackAndQueues;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {4, 2, 3};

        System.out.println(trapOptimal(height));
    }

    public static int trapOptimal(int[] height){
        int n = height.length;
        int left = 0;
        int right = n - 1;

        int lMax = 0;
        int rMax = 0;

        int ans = 0;

        while(left < right){
            lMax = Math.max(lMax, height[left]);
            rMax = Math.max(rMax, height[right]);

            if (lMax < rMax){
                ans += (lMax - height[left]);
                left++;
            } else {
                ans += (rMax - height[right]);
                right--;
            }
        }
        return ans;
    }

    // Brute force
    public static int trap(int[] height) {
        int leftMax;
        int rightMax;
        int total = 0;

        for (int i = 0; i < height.length; i++){
            leftMax = getLeftMax(height, i);
            rightMax = getRightMax(height, i);
            if (height[i] < leftMax && rightMax > height[i]){
                total += Math.min(leftMax, rightMax) - height[i];
            }
        }
        return total;
    }

    public static int getLeftMax(int[] arr, int index) {
        int leftMax = arr[0];

        for (int i = 1; i <= index; i++){
            leftMax = Math.max(leftMax, arr[i]);
        }
        return leftMax;
    }

    public static int getRightMax(int[] arr, int index) {
        int rightMax = 0;

        for (int i = arr.length - 1; i >= index; i--){
            rightMax = Math.max(rightMax, arr[i]);
        }
        return rightMax;
    }

}
