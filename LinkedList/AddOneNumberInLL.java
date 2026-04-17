package com.dsa.LinkedList;

import static com.dsa.LinkedList.Utility.convertArrayToLL;
import static com.dsa.LinkedList.Utility.printLL;

public class AddOneNumberInLL {
    public static void main(String[] args) {
        int[] arr = {9, 9};
        Node head = convertArrayToLL(arr);
        Node h = addOne(head);
        printLL(h);
    }

    // Optimal Approach - TC O(N)

    public static Node addOne(Node head){
        int carry = addOneUtil(head);

        if (carry > 0){
            Node newNode = new Node(carry);
            newNode.next = head;
            return newNode;
        }
        return head;
    }

    public static int addOneUtil(Node head){
        if (head == null){
            return 1;
        }

        int carry = addOneUtil(head.next);

        int sum = head.data + carry;
        head.data = sum % 10;
        return sum / 10;
    }

    // TC : O(3N)
    public static Node addOneNum(Node head){
        Node temp = head;

        Node reverseHead = reverseLL(temp);
        Node newTemp = reverseHead;
        Node prev = null;

        int val = -1;
        int result = 0;

        while (newTemp != null){
            
            if (val != 0){
                if (val == -1) {
                    result = newTemp.data + 1;
                } else if (val > 0){
                    result = newTemp.data + val;
                }
                newTemp.data = (result % 10);
                val = result/10;
            }
            prev = newTemp;
            newTemp = newTemp.next;
        }

        if (val > 0){
            prev.next = new Node(val);
        }

        return reverseLL(reverseHead);
    }

    public static Node reverseLL(Node head){
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
