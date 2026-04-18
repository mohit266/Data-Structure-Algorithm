package com.dsa.LinkedList;

import java.util.ArrayList;
import java.util.List;

import static com.dsa.LinkedList.Utility.convertToDLL;
import static com.dsa.LinkedList.Utility.printDLL;

public class FindPairsWithGivenSumDLL {
    public static void main(String[] args) {
        int [] arr = {1, 2, 4, 5, 6, 8, 9};

        DLLNode head = convertToDLL(arr);
        List<List<Integer>> result = findPairsWithGivenSum(head, 7);
        List<List<Integer>> result1 = findPairsWithGivenTarget(head, 7);
        System.out.println(result1);

    }

    // Optimal Approach
    public static List<List<Integer>> findPairsWithGivenTarget(DLLNode head, int target) {
        DLLNode left = head;
        DLLNode right = findTail(head);
        List<List<Integer>> result =new ArrayList<>();


        while (left.data < right.data){
            if ((left.data + right.data) == target){
                List<Integer> pairsList = new ArrayList<>();
                pairsList.add(left.data);
                pairsList.add(right.data);
                result.add(pairsList);
                left = left.next;
                right = right.back;
            } else if ((left.data + right.data) < target) {
                left = left.next;
            } else {
                right = right.back;
            }
        }
        return result;
    }

    public static DLLNode findTail(DLLNode head){
        DLLNode temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        return temp;
    }

    public static List<List<Integer>> findPairsWithGivenSum(DLLNode head, int target) {
        DLLNode temp1 = head;
        DLLNode fast = head;
        DLLNode temp2 =head;

        List<List<Integer>> result =new ArrayList<>();


        while (fast != null && fast.next != null){
            int value = temp1.data;

            while (temp2 != null){

                if (target == (temp2.data + value)){
                    List<Integer> pairsList = new ArrayList<>();
                    pairsList.add(value);
                    pairsList.add(temp2.data);
                    result.add(pairsList);
                    break;
                }

                temp2 = temp2.next;
            }
            fast = fast.next.next;
            temp1 = temp1.next;
            temp2 = head;
        }

        return result;
    }

}
