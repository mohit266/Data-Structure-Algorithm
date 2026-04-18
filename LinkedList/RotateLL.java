package com.dsa.LinkedList;

import static com.dsa.LinkedList.Utility.convertArrayToLL;
import static com.dsa.LinkedList.Utility.printLL;

public class RotateLL {
    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 4, 5};

        Node head = convertArrayToLL(arr);
        Node rev = rotateRightByKStep(head, 2);
        printLL(rev);
    }

    // Optimal Approach
    public static Node rotateRightByKStep(Node head, int k) {

        if (head == null || head.next == null || k == 0)
            return head;

        int length = 1;
        Node tail = head;

        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        tail.next = head;

        k = k % length;

        int stepsToNewTail = length - k;
        Node newTail = head;
        for (int i = 1; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }

        Node newHead = newTail.next;

        newTail.next = null;

        return newHead;
    }

    // Brute Force Approach

    public static Node rotateRight(Node head, int k) {
        if (head == null || head.next == null) return head;

        int lengthOfLl = getLengthOfLL(head);

        int newK = k % lengthOfLl;

        if (newK == 0){
            return head;
        }

        Node reverseEntireLL = reverseLL(head);
        head = reverseEntireLL;

        Node temp = head;
        Node nextNode;

        Node findKthNode = getKthNode(temp, newK);
        nextNode = findKthNode.next;
        findKthNode.next = null;

        Node reverseNode = reverseLL(head);
        head = reverseNode;

        Node newNode = reverseLL(nextNode);
        temp.next = newNode;

        return head;
    }

    public static int getLengthOfLL(Node head){
        Node temp = head;
        int count = 0;

        while (temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }

    public static Node reverseLL(Node head){
        Node temp = head;
        Node prevNode = null;
        Node nextNode = null;

        while (temp != null){
            nextNode = temp.next;
            temp.next = prevNode;
            prevNode = temp;
            temp = nextNode;
        }
        return prevNode;
    }

    public static Node getKthNode(Node head, int k){
        Node temp = head;
        k = k-1;

        while (temp != null && k > 0){
            temp = temp.next;
            k--;
        }
        return temp;
    }
}
