package com.dsa.LinkedList;

public class LLLengthOfLoop {
    public static void main(String[] args) {

    }

    public static int findLengthOfLoop(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast){
                int cnt = 1;
                fast = fast.next;
                while (slow != fast){
                    fast = fast.next;
                    cnt++;
                }
                return cnt;
            }
        }
        return 0;
    }
}
