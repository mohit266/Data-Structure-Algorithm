package com.dsa.PatternWise.LinkedList.SlowAndFastPointer;

import com.dsa.LinkedList.Node;

// 141. Linked List Cycle
public class LLCycle {
    public static void main(String[] args) {

    }

    // Tortoise and Hare Algo.
    public static boolean hasCycle(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
