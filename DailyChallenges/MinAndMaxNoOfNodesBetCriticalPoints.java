package com.dsa.DailyChallenges;

import com.dsa.LinkedList.Node;

import java.util.Arrays;

import static com.dsa.LinkedList.Utility.convertArrayToLL;

public class MinAndMaxNoOfNodesBetCriticalPoints {

    public static void main(String[] args) {
        MinAndMaxNoOfNodesBetCriticalPoints minAndMax = new MinAndMaxNoOfNodesBetCriticalPoints();
        int[] nums = {2,2,1,3};

        Node head = convertArrayToLL(nums);

        System.out.println(Arrays.toString(minAndMax.nodesBetweenCriticalPoints(head)));

    }


    public int[] nodesBetweenCriticalPoints(Node head) {

        int first = -1;
        int last = -1;

        int min = Integer.MAX_VALUE;

        Node prev = head;
        Node curr = head.next;

        int index = 1;


        while(curr.next != null) {
            if((curr.data > prev.data && curr.data > curr.next.data) ||
                    (curr.data < prev.data && curr.data < curr.next.data)) {
                if(first == -1) {
                    first = index;
                } else {
                    min = Math.min(min,index-last);
                }
                last = index;
            }
            prev = curr;
            curr = curr.next;
            index++;
        }
        if (first == last) return new int[]{-1,-1};

        return new int[] {min, last-first};
    }
}
