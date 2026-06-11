package com.dsa.Heap;

public class CheckIfAnArrayIsMinHeap {
    public static void main(String[] args) {
        CheckIfAnArrayIsMinHeap o = new CheckIfAnArrayIsMinHeap();

        int[] nums = {10, 20, 30, 25, 15};
        System.out.println(o.isHeap(nums));
    }

    public boolean isHeap(int[] nums) {
        int internalNodeIndex = (int) Math.ceil((double) nums.length /2) - 1;

        for (int i = internalNodeIndex; i >= 0; i--){
            if (!heapifyDown(nums, i)){
                return false;
            }
        }
        return true;
    }

    public boolean heapifyDown(int[] nums, int index){
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < nums.length && nums[left] < nums[index]){
            return false;
        }

        if (right < nums.length && nums[right] < nums[index]){
            return false;
        }

        return true;
    }
}
