package com.dsa.PatternWise.LinkedList.SlowAndFastPointer;

// 287. Find the Duplicate Number
public class FindDuplicateNumber {

    public static void main(String[] args) {

        FindDuplicateNumber f = new FindDuplicateNumber();

        int[] nums = {1,3,4,2,2};
        System.out.println(f.findDuplicate(nums));

    }

    public int findDuplicate(int[] nums) {

        int slow = 0;
        int fast = 0;

        while (true){
            slow = nums[slow];
            fast = nums[fast];
            fast = nums[fast];

            if (slow == fast){
                slow = 0;

                while (slow != fast){
                    slow = nums[slow];
                    fast = nums[fast];
                }
                return slow;
            }
        }
    }



}
