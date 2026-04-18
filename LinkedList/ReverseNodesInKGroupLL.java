package com.dsa.LinkedList;

import static com.dsa.LinkedList.Utility.*;

public class ReverseNodesInKGroupLL {
    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 4, 5};

        Node head = convertArrayToLL(arr);
        Node rev =reverseKGroup(head, 2);
        printLL(rev);
    }

    public static Node reverseKGroup(Node head, int k) {
        Node temp = head;
        Node nextNode;
        Node prevNode = null;

        while (temp != null){

            Node kthNode = findKthNode(temp, k);

            if (kthNode == null){
                if (prevNode !=null){
                    prevNode.next = temp;
                }
                break;
            }

            nextNode = kthNode.next;
            kthNode.next = null;

            Node reverseNode = reverseList(temp);

            if (head == temp){
                head = reverseNode;
            } else {
                prevNode.next = kthNode;
            }
            prevNode = temp;
            temp = nextNode;

        }
        return head;

    }

    public static Node findKthNode(Node head, int k){
        if (head == null) return null;
        Node temp = head;
        k = k-1;
        while (temp != null && k > 0){
            temp = temp.next;
            k--;
        }
        return temp;
    }

    public static Node reverseList(Node head) {
        Node temp = head;
        Node prev = null;

        while (temp != null){
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }

}
