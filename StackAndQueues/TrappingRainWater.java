package com.dsa.StackAndQueues;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {4, 2, 3};

        System.out.println(trapOptimal(height));
    }

    public static int trapOptimal(int[] height){
        int left = 0;
        int right = height.length-1;

        int leftMax = 0;
        int rightMax = 0;

        int total = 0;

        while (left < right){
            if (height[left] <= height[right]){
                if (leftMax > height[left]){
                    total = total + (leftMax - height[left]);
                } else {
                    leftMax = height[left];
                }
                left++;
            } else {
                if (rightMax > height[right]){
                    total = total + (rightMax - height[right]);
                } else {
                    rightMax = height[right];
                }
                right--;
            }
        }
        return total;
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
