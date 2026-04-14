package com.dsa.LinkedList;

import static com.dsa.LinkedList.Utility.*;

public class MiddleLL {
    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 4, 5};

        Node head = convertArrayToLL(arr);
        Node midNode = findMiddleNode(head);
        printLL(midNode);
    }


    // OptimalApproach
    public static Node findMiddleNode(Node head){
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    // TC - O(N) + O(N/2)
    public static Node middleNode(Node head) {
        Node temp = head;
        int cnt= 0;

        while (temp != null){
            cnt++;
            temp = temp.next;
        }

        int middleNode = (cnt/2)+1;

        temp = head;

        cnt = 0;
        while (temp != null){
            cnt++;

            if (cnt == middleNode){
                head = temp;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

}
