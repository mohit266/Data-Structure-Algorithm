package com.dsa.Array;

// https://leetcode.com/problems/majority-element/description/
// Moore's Voting Algorithm
public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(arr));
    }

    public static int majorityElement(int[] nums) {
        int element = 0;
        int count = 0;
        int elementOccurrence = 0;
        for (int i=0; i< nums.length; i++){
            if (count == 0){
                element = nums[i];
                count = 1;
            } else if (element == nums[i]){
                count++;
            } else {
                count--;
            }
        }
        for(int i=0; i<nums.length; i++){
            if (nums[i] == element){
                elementOccurrence++;
            }
        }
        if (elementOccurrence > (nums.length/2)){
            return element;
        }
        return -1;
    }

}
