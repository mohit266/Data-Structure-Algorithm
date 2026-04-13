package com.dsa.LinkedList;

import static com.dsa.LinkedList.Utility.*;

public class MiddleLL {
    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 4, 5};

        Node head = convertArrayToLL(arr);
        Node midNode = middleNode(head);
        printLL(midNode);
    }

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
