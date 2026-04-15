package com.dsa.LinkedList;

public class LLCycleII {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7, 9};
    }

    public static Node detectCycle(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast){
                slow = head;

                while (slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
