package com.dsa.LinkedList;

import static com.dsa.LinkedList.Utility.convertArrayToLL;
import static com.dsa.LinkedList.Utility.printLL;

public class AddTwoNumLL {

    public static void main(String[] args) {
        int[] arr = {8, 6};
        int[] arr2 = {6, 4, 8};
        Node head1 = convertArrayToLL(arr);
        Node head2 = convertArrayToLL(arr2);

        Node res = addTwoNumbers(head1, head2);
        printLL(res);

    }
    public static Node addTwoNumbers(Node l1, Node l2) {
        int carry = 0;

        Node newLL = new Node(-1);
        Node temp = newLL;

        while (l1 != null && l2 != null){
            int sum = l1.data + l2.data + carry;
            carry = sum / 10;
            temp.next = l1;
            temp = l1;
            temp.data = sum %10;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 !=null){
            int sum = l1.data + carry;
            carry = sum / 10;
            temp.next = l1;
            temp = l1;
            temp.data = sum %10;
            l1 = l1.next;
        }

        while (l2 !=null){
            int sum = l2.data + carry;
            carry = sum / 10;
            temp.next = l2;
            temp = l2;
            temp.data = sum %10;
            l2 = l2.next;
        }

        if (carry > 0){
            temp.next = new Node(carry);
        }

        return newLL.next;
    }

}
