package com.dsa.LinkedList;

public class LinkedListBasic {
    public static void main(String[] args) {
        int[] arr = {12, 2, 5, 9};

        // Converting array to Linked List.
        Node head = convertArrayToLL(arr);

        // Traversing through Linked List.
        printLL(head);

        /*

        --- Delete Operations ---

        // Searching in LL if elements presents or not.
        System.out.println("\n" + checkIfPresent(head, 12));

        // Delete head in LL
        Node newHead = deleteHead(head);
        System.out.print("Head deleted :: ");
        printLL(newHead);

        // Delete tail in LL
        Node newHeadWithRemovedTail = deleteTail(head);
        System.out.print("Tail deleted :: ");
        printLL(newHeadWithRemovedTail);

        // Delete kth element in LL
        Node removeNode = removeKthNode(head, 2);
        System.out.println("2nd Node Deleted :: ");
        printLL(removeNode);

        // Delete element in LL
        Node removeEle = removeElement(head, 12);
        System.out.println("Delete 12 from LL :: ");
        printLL(removeEle); */

        // ---- Insert Operations ----

        Node insertNewNode = insertNewHead(head, 1);
        System.out.println("Inserted new node 1 :: ");
        printLL(insertNewNode);

        Node insertTailNode = insertTail(head, 15);
        System.out.println("Insert new tail node 15 :: ");
        printLL(insertTailNode);
    }

    public static Node insertNewHead(Node head, int k){
        return new Node(k, head);
    }

    public static Node insertTail(Node head, int k){
        if (head == null) {
            return new Node(k);
        }

        Node temp = head;

        while (temp.next != null){
            temp = temp.next;
        }

        Node newNode = new Node(k);
        temp.next = newNode;

        return head;

    }

    public static Node removeKthNode(Node head, int k){
        if (head == null) return head;

        Node temp = head;
        if (k == 1){
            head = temp.next;
            temp.next = null;
            return head;
        }
        int cnt = 0;
        Node prevNode = null;

        while(temp != null){
            cnt++;
            if (cnt == k){
                prevNode.next = prevNode.next.next;
                temp.next = null;
                break;
            }
            prevNode = temp;
            temp = temp.next;
        }
        return head;
    }

    public static Node removeElement(Node head, int element) {
        if (head == null) return head;

        Node temp = head;
        if (temp.data == element){
            head = temp.next;
            temp.next = null;
            return head;
        }

        Node prevNode = null;

        while (temp != null) {
            if (temp.data == element) {
                prevNode.next = prevNode.next.next;
                temp.next = null;
                break;
            }
            prevNode = temp;
            temp = temp.next;
        }
        return head;
    }

    public static Node deleteHead(Node head){
        if(head == null) return head;
        Node temp = head;
        head = head.next;
        return head;
    }

    public static Node deleteTail(Node head){
        Node temp = head;

        if (head == null || head.next == null) return head;

        while(temp.next.next != null){
            temp = temp.next;
        }

        temp.next = null;
        return head;
    }

    public static void printLL(Node head){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static Node convertArrayToLL(int[] arr){
        Node head = new Node(arr[0]);
        Node mover = head;

        for (int i = 1; i < arr.length; i++){
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    public static boolean checkIfPresent(Node head, int element){
        Node temp = head;

        while (temp != null){
            if (temp.data == element){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

}